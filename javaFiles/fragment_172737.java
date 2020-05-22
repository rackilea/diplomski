package de.scrum_master.app;

public class DoStuff {
    private ServiceSAO serviceSAO;
    private ServiceInput serviceInput;

    void init() {
        serviceSAO = new ServiceSAO("SAO");
        serviceInput = new ServiceInput("Input");
    }

    @PublishEventToService
    public void hello() {
        serviceInput.setDetail("batman");
    }

//  @PublishEventToService
    public void otherMethod() {
        serviceInput.setDetail("foobar");
    }

    public static void main(String[] args) {
        DoStuff doStuff = new DoStuff();
        doStuff.init();
        doStuff.hello();
        doStuff.otherMethod();
    }
}