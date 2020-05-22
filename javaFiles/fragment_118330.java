public class Outer {
    private Object x;

    class Inner {
        public Object lookAtOuter() {
            return Outer.this.x;
        }
    }
}