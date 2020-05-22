public class MyController
    /**
     * The system wide JSR-303 validator, which checks if annotations ({@link NotNull}, {@link NotBlank}, etc. ) are fulfilled.
     */
    @Autowired
    protected Validator validator;

    @PostMapping(value = "/admin/staff/create/employee")
    public ModelAndView createEmployee(@ModelAttribute ("employee") Employee employee, @RequestPart("image")MultipartFile image, BindingResult result) {

        validator.validate(employee, result);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/admin_layout");
        ...
        if (result.hasErrors()) {
            System.out.println("has errors");
            return mav;
        }
    }
}