#!/opt/jdk-11.0.1/bin/java --source 11 
public class Test {
    public static void main(String ... args) {
        System.out.println("Hello " + (args.length == 0 ? "world!" : args[0]));
    }
}