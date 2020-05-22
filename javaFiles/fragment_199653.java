@Override
public boolean isValid(Object bean, ConstraintValidatorContext ctx) throws MyException {
    try {
        // ...
    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        logger.info("Necessary attributes can't be accessed: {}", e.getMessage());
        throw new MyException(e);
    }
}