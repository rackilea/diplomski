public class X extends C2 {
    private transient Object o;

    public X(Object o) {
        this.o = o;
    }

    public void delegateLogic() {
        Object my_o = o;  // refrences main's local variable
        // huge method body
        // object o local to main is required here  
    }
}