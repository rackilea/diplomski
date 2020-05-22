@Configuration
public class DroolsAutoConfiguration {

private static final String RULES_PATH = "rules/";

@Bean
public KieFileSystem kieFileSystem() throws IOException {
    KieFileSystem kieFileSystem = getKieServices().newKieFileSystem();
    for (Resource file : getRuleFiles()) {
        kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_PATH + file.getFilename(), "UTF-8"));
    }        
    return kieFileSystem;
}

private Resource[] getRuleFiles() throws IOException {
    ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
    return resourcePatternResolver.getResources("classpath*:" + RULES_PATH + "**/*.*");
}

@Bean
public KieContainer kieContainer() throws IOException {
    final KieRepository kieRepository = getKieServices().getRepository();

    kieRepository.addKieModule(new KieModule() {
        public ReleaseId getReleaseId() {
            return kieRepository.getDefaultReleaseId();
        }
    });

    KieBuilder kieBuilder = getKieServices().newKieBuilder(kieFileSystem()); 
    kieBuilder.buildAll();

    return getKieServices().newKieContainer(kieRepository.getDefaultReleaseId());
}

private KieServices getKieServices() {
    return KieServices.Factory.get();
}

@Bean
public KieBase kieBase() throws IOException {
    return kieContainer().getKieBase();
}

@Bean
public KieSession kieSession() throws IOException {
    return kieContainer().newKieSession();
}

@Bean
public KModuleBeanFactoryPostProcessor kiePostProcessor() {
    return new KModuleBeanFactoryPostProcessor();
}
}