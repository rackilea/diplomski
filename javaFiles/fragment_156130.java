class Service {
    public String doSomething(){
        // interact with external service
        // make some heavy computation
        return "real result";
    }
}

class ServiceStub extends Service {
    @Override
    public String doSomething(){
        return "stubbed result";
    }
}