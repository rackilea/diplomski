public class MyClass1 extends JLabel {
    MyVariableWrapper myVariableWrapper;
    MyClass1() {
        super();
        myVariableWrapper = new MyVariableWrapper();
        // now I have access to `some_var`
    }
}

public class MyClass2 extends JLabel {
    MyVariableWrapper myVariableWrapper;
    MyClass2() {
        super();
        myVariableWrapper = new MyVariableWrapper();
        // now I have access to the same `some_var` as MyClass1
    }

    // this is a wrapper method for your convenience
    // since you don't like the excess code when accessing the variable
    public int getSomeVar() {
        return myVariableWrapper.some_var;
        // or myVariableWrapper.getSomeVar();
    }
    public void setSomeVar(int newvar) {
        myVariableWrapper.some_var = newvar;
        // or myVariableWrapper.setSomeVar(newvar);
    }
}