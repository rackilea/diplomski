public class Parent {
    public int method(){
        return 0;
    }
}

public class child extends Parent {
    //**Error:** We can not append throws clause in the method because
    // parent method do not have a throws clause
    @Override
    public int method() 
        throws IllegalAccessException, NullPointerException,
            Exception {
            //Problem Statement
        return super.method();
    }
}