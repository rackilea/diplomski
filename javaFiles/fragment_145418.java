@Test
public void testSomeMethod() {
    ...
    for (SmartTextField field : SmartTextFieldCollection())
        field.focusGained(new FocusEvent(field.getField(),FocusEvent.FOCUS_GAINED));
        field.focusGained(null);
        assertTrue(condition);
        ...
}