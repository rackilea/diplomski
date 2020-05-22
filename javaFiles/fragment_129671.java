class EnumUtils {

  public static String getDescription(Class enumClass, String enumName) {
    return (String) getFieldValue(enumClass, enumName, "description");
  }

  public static int getValue(Class enumClass, String enumName) {
    return (Integer) getFieldValue(enumClass, enumName, "value");
  }

  public static Object getFieldValue(Class enumClass, String enumName, String fieldName) {
    Object value = null;
    Enum e = Enum.valueOf(enumClass, enumName);
    try {
      Field descriptionField = e.getClass().getDeclaredField(fieldName);
      value = descriptionField.get(e);
    } catch(NoSuchFieldException | IllegalAccessException ex) { /* Handle that as you want */ }
    return value;
  }
}