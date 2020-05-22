public class ModuleCachingMetadataReaderFactory extends CachingMetadataReaderFactory {
    private Log logger = LogFactory.getLog(ModuleCachingMetadataReaderFactory.class);

    @Override
    public MetadataReader getMetadataReader(String className) throws IOException {
        List<Module> modules = ModuleManager.getStartedModules();

        logger.debug("Checking if " + className + " is contained in loaded modules");

        for (Module module : modules) {
            if (className.startsWith(module.getPackageName())) {
                String resourcePath = module.getExpandedJarFolder().getAbsolutePath() + "/" + ClassUtils.convertClassNameToResourcePath(className) + ".class";

                File file = new File(resourcePath);

                if (file.exists()) {
                    logger.debug("Yes it is, returning MetadataReader of this class");

                    return getMetadataReader(getResourceLoader().getResource("file:" + resourcePath));
                }
            }
        }

        return super.getMetadataReader(className);
    }
}