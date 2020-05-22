private final Object inputLock = new Object();

//...

public String ask(String string) {
    println(string);
    hasInput = false;

    do {
        synchronized (inputLock) {
            try {
                System.out.println("Wait");
                inputLock.wait();
            } catch (InterruptedException ex) {
            }
        }
    } while (!hasInput);
    println("done");
    return processLastInput();
}