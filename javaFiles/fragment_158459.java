public String generate(File template) {

    Configuration cfg = new Configuration();
    cfg.setTemplateLoader(new TemplateAbsolutePathLoader());
    Template tpl = cfg.getTemplate(template.getAbsolutePath());

    // ...
}