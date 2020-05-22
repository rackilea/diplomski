public class HelloWorld {
    static {
        System.loadLibrary("test_app_wrap"); 
    }
    static public void main(String argv[]) {
        test_app.print_hello();
    }
}