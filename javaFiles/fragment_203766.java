public class Program {
    public static void main(String[] args) {
        new Program.run(); //this creates an object so you can get rid of static methods
    }

    void run() {
        //your code goes here instead of inside main
        ...
    }

    void method1() { //these no longer have to be static
        ...
    }

    void method2() {
        ...
    }
}