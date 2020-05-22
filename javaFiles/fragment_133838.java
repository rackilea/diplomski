public class Parser {
    private my_Application daddy = null;
    public Parser(my_Application app) {
        daddy = app;
    }

    public void log(String input){
        daddy.log(input);
    }
}