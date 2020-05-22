@Test
public void testMocked1() {
    KeyValueInterface keyValue = Mockito.mock(KeyValueInterface.class);
    KeyValueInterface result = (new ValueFinder()).findValueForKey(keyValue);

    // tests that the value has been set to "foo"
    verify(keyValue).setValue("foo");

    // tests that the method returns its argument
    assertSame(keyValue, result);
}