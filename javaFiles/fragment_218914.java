public class OptionsValidator implements ConstraintValidator<Options, Object> {
    private List<String> values;
    private boolean optional;

    @Override
    public void initialize(Options params) {
        values = Arrays.asList(params.values().data);
        optional = params.optional();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (optional && value == null) {
            return true;
        }

        if (value instanceof String[]) {
            String[] valArray = (String[]) value;
            if (!optional && valArray.length == 0) {
                return false;
            }

            for (String val : valArray) {
                if (!values.contains(val)) {
                    return false;
                }
            }

            return true;
        } else if (value instanceof String) {
            String val = (String) value;
            if (optional && val.trim() == "") {
                return true;
            }

            return val != null && values.contains(val);
        }

        return false;
    }
}