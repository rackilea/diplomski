public interface MyInterface {
    int someint = 9;
}

public class MyClass1 extends JLabel implements MyInterface {
    //this class has access to `someint`
}

public class MyClass2 extends JLabel implements MyInterface {
    // also has access to `someint`
}