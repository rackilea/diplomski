public class AcmeController {

    private WebDataBinder binder;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {

        this.binder = binder;

    }