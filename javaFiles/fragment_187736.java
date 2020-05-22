public class CustomValidator {

    // ------------------------------------------------------------ Constructors

    /**
     * Constructor for CustomValidator.
     */
    public CustomValidator() {
        super();
    }

    // ---------------------------------------------------------- Public Methods

    /**
     * Example validator for comparing the equality of two fields
     *
     * http://struts.apache.org/userGuide/dev_validator.html
     * http://www.raibledesigns.com/page/rd/20030226
     */
    public static boolean validateTwoFields(
        Object bean,
        ValidatorAction va,
        Field field,
        ActionMessages errors,
        HttpServletRequest request) {

        String value =
            ValidatorUtils.getValueAsString(bean, field.getProperty());
        String property2 = field.getVarValue("secondProperty");
        String value2 = ValidatorUtils.getValueAsString(bean, property2);

        if (!GenericValidator.isBlankOrNull(value)) {
            try {
                if (!value.equals(value2)) {
                    errors.add(
                        field.getKey(),
                        Resources.getActionMessage(request, va, field));

                    return false;
                }
            } catch (Exception e) {
                errors.add(
                    field.getKey(),
                    Resources.getActionMessage(request, va, field));
                return false;
            }
        }
        return true;
    }

}