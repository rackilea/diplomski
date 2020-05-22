import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TestClass {

    @Test
    public void test() {
        MyClass myClass = new MyClass();
        MyClass spy = spy(myClass); // creates a spy for myClass
        doReturn(new HashSet<File>() {{ add(new File("file1")); }}).when(spy).methodB("", ""); // stubbing method B
        spy.methodA("", ""); // calling the real method A
    }

}

class MyClass {

    public Set<File> methodB(String param1, String param2) {
        return new HashSet<File>() {{ add(new File("file2")); }};
    }

    public void methodA(String param1, String param2) {
        Set<File> fileSet = methodB(param1, param2);
        System.out.println(fileSet); // prints [file1] and not [file2], meaning the stubbed method was called and not the real one
    }

}