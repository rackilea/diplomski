Configuration config = new Configuration();
 LocalTemplateLoader loader = new LocalTemplateLoader();
 // this is designed for spring
 loader.setBaseDir("/var/cms/live");
 config.setTemplateLoader(loader);
 ...