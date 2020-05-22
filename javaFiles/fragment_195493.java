public class SpringFXMLLoader {

    @Autowired
    private ApplicationContext springContext ;

    public Parent load(String resourceName) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resourceName));
        loader.setControllerFactory(springContext::getBean);
        return loader.load();
    }
}