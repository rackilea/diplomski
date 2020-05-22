import java.util.function.Predicate;

public class TestLamba {

    public static void main(String... args) {

        Predicate<String> t = String::isEmpty; // this works
        Predicate<TestLamba > t2 = TestLamba::isEmptyTest; //Now this will work
    }

    public boolean isEmptyTest() {
        return true;
    }

}