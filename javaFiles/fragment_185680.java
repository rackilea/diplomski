@Configuration
public class StaticWithoutHtmlMappingConfigurer extends WebMvcConfigurerAdapter implements WebMvcConfigurer {

    private static final String STATIC_FILE_PATH = "src/main/resources/static";

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        try {
            Files.walk(Paths.get(STATIC_FILE_PATH), new FileVisitOption[0])
                .filter(Files::isRegularFile)
                .map(f -> f.toString())
                .map(s -> s.substring(STATIC_FILE_PATH.length()))
                .map(s -> s.replaceAll("\\.html", ""))
                .forEach(p -> registry.addRedirectViewController(p, p + ".html"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        // add the special case for "index.html" to "/" mapping
        registry.addRedirectViewController("/", "index.html");
    }

}