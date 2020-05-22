public interface Inner {
    void innerAction();
}

public class Outer {

    public void methodInOuter() {}

    private Inner inner = new Inner() {
        public void innerAction() {
            // calling a method outside of scope of this anonymous class
            methodInOuter();  
        }
    }
}