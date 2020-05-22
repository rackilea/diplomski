public class InstanceofTest {
    public static class Test {}
    public static final class TestFinal {}
    public static void main(String[] args) {

        Test test = null;

         // 1. outputs: false
        System.out.println(test instanceof java.util.Map);

        // 2. COMPILATION ERROR
        System.out.println(test instanceof java.util.HashMap);

        TestFinal testFinal = null;

        // 3. COMPILATION ERROR
        System.out.println(testFinal instanceof java.util.Map);

        // 4. COMPILATION ERROR
        System.out.println(testFinal instanceof java.util.HashMap); 
    }
}