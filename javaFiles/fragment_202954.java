/**
 * Custom scanner that detects bean candidates on the classpath (through {@link ClassPathBeanDefinitionScanner} and on the module folder.
 * @author Ludovic Guillaume
 */
public class ModuleBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {
    private ResourcePatternResolver resourcePatternResolver;
    private MetadataReaderFactory metadataReaderFactory;

    /**
     * @see {@link ClassPathBeanDefinitionScanner#ClassPathBeanDefinitionScanner(BeanDefinitionRegistry, boolean)}
     * @param registry
     * @param useDefaultFilters
     */
    public ModuleBeanDefinitionScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
        super(registry, useDefaultFilters);

        try {
            // get parent class variable
            resourcePatternResolver = (ResourcePatternResolver)getResourceLoader();

            // not defined as protected and no getter... so reflection to get it
            Field field = ClassPathScanningCandidateComponentProvider.class.getDeclaredField("metadataReaderFactory");
            field.setAccessible(true);
            metadataReaderFactory = (MetadataReaderFactory)field.get(this);
            field.setAccessible(false);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Scan the class path for candidate components.<br/>
     * Include the expanded modules folder {@link ModuleManager#getExpandedModulesFolder()}.
     * @param basePackage the package to check for annotated classes
     * @return a corresponding Set of autodetected bean definitions
     */
    @Override
    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<BeanDefinition>(super.findCandidateComponents(basePackage));

        logger.debug("Scanning for candidates in module path");

        try {
            String packageSearchPath = "file:" + ModuleManager.getExpandedModulesFolder() + "/**/*.class";

            Resource[] resources = this.resourcePatternResolver.getResources(packageSearchPath);
            boolean traceEnabled = logger.isTraceEnabled();
            boolean debugEnabled = logger.isDebugEnabled();

            for (Resource resource : resources) {
                if (traceEnabled) {
                    logger.trace("Scanning " + resource);
                }
                if (resource.isReadable()) {
                    try {
                        MetadataReader metadataReader = this.metadataReaderFactory.getMetadataReader(resource);

                        if (isCandidateComponent(metadataReader)) {
                            ScannedGenericBeanDefinition sbd = new ScannedGenericBeanDefinition(metadataReader);
                            sbd.setResource(resource);
                            sbd.setSource(resource);

                            if (isCandidateComponent(sbd)) {
                                if (debugEnabled) {
                                    logger.debug("Identified candidate component class: " + resource);
                                }
                                candidates.add(sbd);
                            }
                            else {
                                if (debugEnabled) {
                                    logger.debug("Ignored because not a concrete top-level class: " + resource);
                                }
                            }
                        }
                        else {
                            if (traceEnabled) {
                                logger.trace("Ignored because not matching any filter: " + resource);
                            }
                        }
                    }
                    catch (Throwable ex) {
                        throw new BeanDefinitionStoreException("Failed to read candidate component class: " + resource, ex);
                    }
                }
                else {
                    if (traceEnabled) {
                        logger.trace("Ignored because not readable: " + resource);
                    }
                }
            }
        }
        catch (IOException ex) {
            throw new BeanDefinitionStoreException("I/O failure during classpath scanning", ex);
        }

        return candidates;
    }
}