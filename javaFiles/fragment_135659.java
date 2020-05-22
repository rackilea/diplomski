@Component
public class CountryEditor extends PropertyEditorSupport {

    private @Autowired CountryService countryService;

    // Converts a String to a Country (when submitting form)
    @Override
    public void setAsText(String text) {
        Country c = this.countryService.findById(Long.valueOf(text));

        this.setValue(c);
    }

}