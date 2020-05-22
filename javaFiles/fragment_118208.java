// src/test/java/pkg/SomeMock.java
import mockit.Mock;
import mockit.MockUp;

public class SomeMock extends MockUp<SomeClass> {
    @Mock
    public void $init(String a, Integer b) {
        System.out.println("Mock constructor called");
    }
}