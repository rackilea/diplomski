public class ChoiceValidator
        implements ConstraintValidator<Choice, Object> {

    private List<String> fields;

    @Override
    public void initialize(final Choice choice) {
        fields = Arrays.asList(choice.fields());
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext ctx) {

        int nonNullFieldCount = 0;
        for (String field : fields) {
            try {
                final String fieldValue = BeanUtils.getProperty(value, field);
                if (fieldValue != null) {
                    nonNullFieldCount++;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        return nonNullFieldCount == 1;
    }

}