//base class Base.java
public abstract class Base {
    public static Base getInstance() 
    {
        //#ifdef ANDROID
        return new AndroidBaseImpl();
        //#elif J2ME
        return new J2MEBaseImpl();
        //#endif
    }

    public abstract void doSomething();
}

//Android specific implementation AndroidBaseImpl.java
//#ifdef ANDROID
public class AndroidBaseImpl extends Base {
    public void doSomething() {
     //Android code
    }
}
//#endif

//J2ME specific implementation J2MEBaseImpl.java
//#ifdef J2ME
public class J2MEBaseImpl extends Base {
    public void doSomething() {
        // J2Me code
    }
}
//#endif