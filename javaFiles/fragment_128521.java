public class Class1 {
    public SomeReturnType2 method1(Function<SomeReturnType1, SomeParameterType1> yourDoSomething) {         
        SomeReturnType1 something = /* your computation of method1 */
        SomeParameterType1 param = yourDoSomething.apply(something);
        return method2(param);
    }

    private SomeReturnType2 method2(SomeParameterType1 param1){
        // do some calculation of method2
    }
}

public class Class2 {
    public void doSomething(){
        Class1 class1 = new Class1();
        class1.method1((theReturnValueOfMethod1Computation) -> {
            /* do what do you want to do with the return value + return what do you want to pass to method2 */
        });
    }
}