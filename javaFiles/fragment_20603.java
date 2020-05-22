ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
resolver.setTemplateMode("HTML5");
resolver.setSuffix(".html");
TemplateEngine templateEngine = new TemplateEngine();
templateEngine.setTemplateResolver(resolver);
final Context context = new Context(Locale.CANADA);
String name = "John Doe";
context.setVariable("name", name);

final String html = templateEngine.process("myhtml", context);