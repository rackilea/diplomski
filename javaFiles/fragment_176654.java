public class ExampleService {
    public String strangeMethod() {

        return privateMethod();
    }

    private String privateMethod() {
        return "b";
    }
}