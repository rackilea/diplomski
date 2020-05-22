...
public class MyController {

    private @Autowired CountryEditor countryEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Country.class, this.countryEditor);
    }

    ...

}