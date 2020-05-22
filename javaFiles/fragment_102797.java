import org.apache.velocity.app.Velocity;
    //...

    @Autowired
    JavaMailSenderImpl sender;
    // ...

    String mailBody = "Hello user ${username}!"; // This will depend on how you would get your mail content
    MimeMessage message = sender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);
    helper.setTo("someone@host1.com");
    message.setFrom("me@host2.com");
    // Create the context for data input
    VelocityContext context = new VelocityContext();
    context.put("username", "Foo");
    // Create the Writer you would use as the output
    StringWriter writer = new StringWriter();
    // Evaluate your text entry
    Velocity.evaluate(context, writer, "EvalError", mailBody);
    message.setText(writer.toString(), true);

    //...
    sender.send(message);