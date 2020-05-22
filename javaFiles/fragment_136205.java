public class ClasssATest {

    @Test
    public void someTest() {
        String input = "a string";
        ExternalObject externalObject = Mockito.mock(ExternalObject.class);
        Mockito.when(externalObject.parseString(eq(input))).thenReturn(externalObject);

        ClassA sut = new ClassA(externalObject, input);
        ...
    }
}