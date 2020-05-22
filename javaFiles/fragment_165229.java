@Bean
    public TomcatServletWebServerFactory tomcatFactory() {
        return new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                Set<String> pattern = new LinkedHashSet<>();

                pattern.add("jaxb*.jar");
                pattern.add("jaxws*.jar");          

                StandardJarScanFilter filter = new StandardJarScanFilter();
                filter.setTldSkip(StringUtils.collectionToCommaDelimitedString(pattern));

                ((StandardJarScanner) context.getJarScanner()).setJarScanFilter(filter);

            }
        };
    }