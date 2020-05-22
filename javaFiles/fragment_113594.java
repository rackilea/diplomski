import org.thymeleaf.TemplateEngine; 

   @Autowired
    private TemplateEngine templateEngine;

       Context context = new Context();
            context.setVariables(mail.getModel());
            String html = templateEngine.process("email-template", context);