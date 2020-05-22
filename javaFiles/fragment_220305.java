public String myFunc(String input) throws Exception
{
    MyClass object = new MyClass(input);
    Thread  thread = new Thread(object);

    thread.start();
    // Do whatever you wanna do...
    // ...
    // ...
    // And when you need the thread's output:
    thread.join();
    return object.getOutput();
}