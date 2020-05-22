abstract class TemplateSuperClass implements Runnable {
    public void run() {
        //some setup code here
        String message = taskWork(...);
        socket.write(message);
        //common cleanup code
    }

    abstract String taskWork(...);
}

class HelloWorld extends TemplateSuperClass {
    String taskWork(...) {
        return "Hello World";
    }
}