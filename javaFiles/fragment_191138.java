public interface MyInterface {
    //automatically public
    int method();
}

public class A implements MyInterface {
    @Override //important
    //not static
    public int method() {
        /* your implementation goes here*/
        return ...;
    }
}

public class B implements MyInterface {
    @Override //important to check method override at compile time
    public int method() {
        /* your implementation goes here*/
        return ...;
    }
}

//define any other class...