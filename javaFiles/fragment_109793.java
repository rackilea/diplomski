public static void initialize() {
    ctx = new AnnotationConfigApplicationContext();
    ctx.getEnvironment().getPropertySources().addFirst(new PlayFrameworkPropertySource());
    ctx.scan("somepackage");
    ctx.refresh();
}