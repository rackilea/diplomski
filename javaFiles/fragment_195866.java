public static void main(String[] args) {
    new SpringApplicationBuilder(Application.class)
        .web(WebApplicationType.NONE) // Use this for Spring boot 2.x
        .web(false) // Use this for Spring boot 1.x
        .run(args);
}