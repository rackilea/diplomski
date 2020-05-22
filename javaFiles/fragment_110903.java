public class TestClass{

    @MyAnnotationForMethod
    public void simpleTestMethod(@MyAnnotationForParam final String param1){
        System.out.println("Method body (simple)");
    };

    @MyAnnotationForMethod
    public void complexTestMethod(final String param1,
        @MyAnnotationForParam final Float param2,
        @MyAnnotationForParam final Boolean param3){
        System.out.println("Method body (complex)");
    };

    public static void main(final String[] args){
        System.out.println("Starting up");
        final TestClass testObject = new TestClass();
        testObject.simpleTestMethod("Hey");
        testObject.complexTestMethod("Hey", 123.4f, false);
        System.out.println("Finished");
    }

}