public class ConcreteWordListObserverA implements WordListObserver {
    @Override
    public void notify(WordListUpateEvent event) {
        System.out.println("update item at index: " + event.getChangedIndex());
    }
}