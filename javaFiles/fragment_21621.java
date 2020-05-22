@Test
public void any_should_be_actual_alias_to_anyObject() {
    mock.simpleMethod((Object) null);

    verify(mock).simpleMethod(any());
    verify(mock).simpleMethod(anyObject());
}