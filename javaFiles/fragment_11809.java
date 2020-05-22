public class MyBean {
    @Required(groups = {All.class, Step1.class})
    @MinLength(value = 4, groups = {All.class})
    public String username;
}

MyBean bean = new MyBean();
ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
Validator validator = factory.getValidator();