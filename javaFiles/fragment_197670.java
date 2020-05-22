@Controller
public class MyController {

    @Autowired
    private MyFormValidador formValidador;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(formValidador);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String execute(@Valid MyForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "errorview";
        }

        return "successview";
    }

}

@Component
public class MyFormValidador implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return MyForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "linkName", "linkName.required", "Link name must be informed");
    }

}