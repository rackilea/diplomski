public class ChoiceValidator implements ConstraintValidator<Choice, Object> {

    private List<Class<?>> clazzes;

    @Override
    public void initialize(Choice choice) {
        clazzes = Arrays.asList(choice.types());
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        for (Class<?> clazz : clazzes) {
            if (value.getClass().equals(clazz)) {
                return true;
            }
        }
        return false;
    }
}