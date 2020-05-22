@JsonAnySetter
public void putUserField(String userKey, Map<String, String> userValue) 
  throws NoSuchFieldException {
    String actualFieldName = getActualFieldName(userKey);
    Field field = this.getClass().getDeclaredField(actualFieldName);
    field.setAccessible(true);
    ReflectionUtils.setField(field, this, userValue.get("value"));
}

private String getActualFieldName(String userKey) {
    return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, userKey);
}