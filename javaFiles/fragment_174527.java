@Override
public boolean isValid(final Object value, final ConstraintValidatorContext context) {
    final BeanWrapperImpl beanWrapper = new BeanWrapperImpl(value);

    for (final String f : fields) {
       final Object fieldValue = beanWrapper.getPropertyValue(f);

       if (fieldValue == null) {
          return false;
       }
    }

    return true;
}