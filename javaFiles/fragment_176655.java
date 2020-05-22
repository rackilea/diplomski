@PrepareForTest(ExampleService.class)
@RunWith(PowerMockRunner.class)
public class TestPrivate {

    @Test
    public void strangeMethodTest() throws Exception {
        ExampleService exampleService = PowerMockito.spy(new ExampleService());
        PowerMockito.when(exampleService, "privateMethod").thenReturn("a");
        String actual = exampleService.strangeMethod();

        assertEquals("a",actual);
    }

}