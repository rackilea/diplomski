public class A {
     final Map<String, String> map = new HashMap<String, String>(); {
        // put things in map.
     }
     final int number; {
        int number;
        try {
            number = throwsAnException();
        } catch (Exception e) {
            number = 5;
        }
        this.number = number;
     }

     public A() { /* constructor 1 */ }
     public A(int i) { /* constructor 2 */ }
}