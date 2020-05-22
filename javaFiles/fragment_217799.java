public class Outer {
    private class Inner {}
        public String foo() {
            return new Inner().toString(); 
        }
}