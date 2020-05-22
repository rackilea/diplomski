public class Main {

    enum Test{
        First(methodCatchingException()){
            // ...
        };

        Test(Object obj){
            //...
        }
    }

    static Object method() throws Exception{
        // ...
        if (someCondition){
            throw new Exception();
        }
    }

    static Object methodCatchingException() {
        try {
            return method();
        } catch (Exception ex) {
            throw new SomeRuntimeException("the sky is falling!", ex);
        }
    }
}