@RunWith(PowerMockRunner.class)
@PrepareForTest({Resource.class})
public class MockingTest{

    @Test
    public void shouldMockVoidStaticMethod() throws Exception {
        PowerMockito.spy(Resource.class);
        PowerMockito.doNothing().when(Resource.class, "readResources", Mockito.any(String.class));

        //no exception heeeeere!
        Resource.readResources("whatever");

        PowerMockito.verifyStatic();
        Resource.readResources("whatever");
    }

}

class Resource {
    public static void readResources(String someArgument) {
        throw new UnsupportedOperationException("meh!");
    }
}