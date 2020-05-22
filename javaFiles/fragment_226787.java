public class YourClassTest {    

    //Class you want to test
    private YourClass testee;

    @Test
    public void testSomeMethod() {

        testee = new YourClass(); 

        //
        // ThirdPartyClass. When the method someStringValue()
        // is called you control the value returned
        //
        ThirdPartyClass testDoc = mock(ThirdPartyClass.class);          
        when(testDoc.someStringValue()).thenReturn("aString");

        // Call method to test and pass mock as argument
        testee.someMethod(testDoc);

        // Check state of your object you want to test
        assertThat(testee.getValue(), equalTo("aString"));      
    }
}