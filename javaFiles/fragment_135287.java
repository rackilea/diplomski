public class Parent {
    public int method() 
        throws IllegalAccessException,NullPointerException, Exception {
        return 0;
    }
}
public class child extends Parent {
    // throws is part of method because parent method
    // have throws clause
    @Override
    public int method() 
        throws IllegalAccessException, NullPointerException,
            Exception {
            //Problem Statement
        return super.method();
    }
}