class MyService {
    private Controller controller;

    public MyService() {
        controller = new MyController(this);
    }
}