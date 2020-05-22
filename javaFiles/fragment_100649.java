public boolean isTemplateAvailable(String view, Environment environment,
        ClassLoader classLoader, ResourceLoader resourceLoader) {
    if (ClassUtils.isPresent("org.apache.jasper.compiler.JspConfig", classLoader)) {
        String prefix = getProperty(environment, "spring.mvc.view.prefix",
                "spring.view.prefix", WebMvcAutoConfiguration.DEFAULT_PREFIX);
        String suffix = getProperty(environment, "spring.mvc.view.suffix",
                "spring.view.suffix", WebMvcAutoConfiguration.DEFAULT_SUFFIX);
        return resourceLoader.getResource(prefix + view + suffix).exists();
    }
    return false;
}