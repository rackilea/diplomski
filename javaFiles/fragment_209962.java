context.setVariables(messageMap);

    TemplateEngine templateEngine = new TemplateEngine();

    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
    templateResolver.setPrefix("templates/mail/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode(TemplateMode.HTML);
    templateResolver.setCharacterEncoding("UTF-8");
    templateResolver.setOrder(0);

    templateEngine.setTemplateResolver(templateResolver);