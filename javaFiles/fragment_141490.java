public class StringEnumerationValidator implements ConstraintValidator<StringEnumeration, String> {

  private Set<String> AVAILABLE_ENUM_NAMES;

  @Override
  public void initialize(StringEnumeration stringEnumeration) {
    Class<? extends Enum<?>> enumSelected = stringEnumeration.enumClass();
    //Set<? extends Enum<?>> enumInstances = EnumSet.allOf(enumSelected);
    Set<? extends Enum<?>> enumInstances = Sets.newHashSet(enumSelected.getEnumConstants());
    AVAILABLE_ENUM_NAMES = FluentIterable
            .from(enumInstances)
            .transform(PrimitiveGuavaFunctions.ENUM_TO_NAME)
            .toSet();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if ( value == null ) {
      return true;
    } else {
      return AVAILABLE_ENUM_NAMES.contains(value);
    }
  }

}