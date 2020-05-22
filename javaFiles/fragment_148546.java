public class CallingClass{
    CallingClass(){
        ClassTwo thread = new ClassTwo(this);
        thread.start();
    }

    public void someMethod(){}

}