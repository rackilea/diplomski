public class Start {

    public static void main(String[] args) {
        Subject subject = new Subject();

        subject.getWordListObservableRegistration().addObserver(new ConcreteWordListObserverA());
        subject.getWordListObservableRegistration().addObserver(new ConcreteWordListObserverA());

        subject.doSomething();
    }
}