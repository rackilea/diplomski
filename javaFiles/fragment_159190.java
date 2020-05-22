public class ExceptionGenerator {

    public void generateException() throws MyLocalizedThrowable {
        throw new MyLocalizedThrowable("key1");
    }
}