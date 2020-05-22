class A inheritance P {
    static protected I_able AInstance = null; 

    static public I_able getInstance() {
        if ( AInstance == null ) 
             AInstance = new A() ;
        return (A) AInstance ;
    } // getInstance()

    override public void method1() {
        ...
    } // method1() 
} // A()

class B inheritance P {
    static protected I_able BInstance = null; 

    static public I_able getInstance() {
        if ( BInstance == null ) 
            BInstance = new B() ;
        return (B) BInstance ;
    } // getInstance()

    override public void method1() {
        ...
    } // method1() 
} // B()