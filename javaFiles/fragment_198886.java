// TestEnum.java
public enum TestEnum {
    A, B, C;
}

// TestAnnotation.java
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    TestEnum value();
}

// TestClass.java
@TestAnnotation(TestEnum.C)
public class TestClass {

}

// ReadAnnotation.java
public class ReadAnnotation {
    public static void main(String[] args) {
        System.out.println(TestClass.class.getAnnotation(TestAnnotation.class).value());
    }
}