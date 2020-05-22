public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) {
  List<BeanDefinitionHolder> configCandidates = new ArrayList<BeanDefinitionHolder>();
  String[] candidateNames = registry.getBeanDefinitionNames();
  for (String beanName : candidateNames) {
    if (ConfigurationClassUtils.checkConfigurationClassCandidate(beanDef, this.metadataReaderFactory)) {
      // Extract component scan
    }
  }
}