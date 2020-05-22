public class Observer implements IObserver {
    @Override
    public void update(AEvent event) {
        System.out.println("I got and event from " + event.getSource() + " with a value of " + event.getValue());
    }
}