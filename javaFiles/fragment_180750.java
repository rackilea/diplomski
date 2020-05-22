MessageSource messageSource = new ReloadableResourceBundleMessageSource();
messageSource.setCacheSeconds(5);
messageSource.setDefaultEncoding("UTF-8");
messageSource.setFallbackToSystemLocale(true);
messageSource.setUseCodeAsDefaultMessage(true);
messageSource.setBasenames(Arrays.asList("classpath:com\neopost\cim\i18n\text\message"));