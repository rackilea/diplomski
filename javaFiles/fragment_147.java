private void killThreadLocal(String klazzName, String fieldName) {
    Field field = Class.forName(klazzName).getDeclaredField(fieldName);
    field.setAccessible(true);  
    Field modifiersField = Field.class.getDeclaredField("modifiers");
    modifiersField.setAccessible(true);
    int modifiers = modifiersField.getInt(field);
    modifiers &= ~Modifier.FINAL;
    modifiersField.setInt(field, modifiers);
    field.set(null, null);
}