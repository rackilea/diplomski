// the PickSomething class and its constructor
class PickSomething implements ActionListener {
    private Consumer<String> consumer;

    public PickSomething(Consumer<String> consumer) {
        this.consumer = consumer;
    }