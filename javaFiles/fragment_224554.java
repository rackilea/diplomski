public interface ResponseHandler {
    void validDataEntered(String data);
    void invalidDataEntered(String data);
}

public class Processor {
    void methodA(String param1, String param2, ResponseHandler h) {
        if (!param1.valid()) {
            h.invalidDataEntered(param1);
            return;
        }
        if (!param2.valid()) {
            h.invalidDataEntered(param2);
            return;
        }
        validDataEntered(param1+":"+param2);
    }
}

public class MainClass implements ResponseHandler {
    Processor p = new Processor();
    public void validDataEntered(String data) {
        System.out.println("Got valid data: "+data);
    }
    public void invalidDataEntered(String data) {
        System.err.println("Got invalid data: "+data);
    }
    public void doSomething() {
        p.methodA("one", "two", this);
    }
}