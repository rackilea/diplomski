import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@Test
public void test1()  {
        //  create mock
        MyClass test = mock(MyClass.class);

        // define return value for method createSoapCall()
        when(test.createSoapCall()).thenReturn(43);

        // use mock in test....
        assertEquals(test.createSoapCall(), 43);
}