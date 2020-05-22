public abstract class BaseController {

    protected String PATH = "";

    public void setPATH(String inPath) {
        PATH = inPath;
    }

    @PostConstruct
    private void init() {
        setPATH(PATH);      
    }

    @ModelAttribute("controllerPath")
    public abstract String getControllerPath();
}