public static void main(String[] args) throws NoSuchMethodException {
    ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
    Validator validator = vf.getValidator();

    Text msg = new Text();

    String inParam = "";

    Method method = Text.class.getMethod("getMessage", String.class);
    ExecutableValidator methodValidator = validator. forExecutables();
    Set<ConstraintViolation<Text>> violations =
        methodValidator.validateParameters(msg, method, new Object[]{inParam});
    if (violations.size() > 0) {
        violations.forEach(v -> System.out.println(v.getMessage()));
    } else {
        //if ok - executing method
        msg.getMessage(inParam);
        //or if return value also need validation:
        //violations = methodValidator.validateReturnValue(msg, method, msg.getMessage(""));
        //violations.forEach(v -> System.out.println(v.getMessage()));
    }

    vf.close();
}