import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class MyInterfaceTest {
    MyInterface myInterface;

    @Test
    public void methodUsingAImplementation() {
        myInterface = new A();
        //code more human-readable and easier to check where the code fails
        assertThat(myInterface.method(), equalTo(<expectedValue>));
    }
    //similar test cases for other implementations
}