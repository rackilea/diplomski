public class ThreadClass extends Thread{
    CallingClass callingClass;

    public ThreadClass(CallingClass callingClass) {
            this.callingClass = callingClass;
    }
    public void run(){
        //Some thread logic
        callingClass.someMethod();
    }
}