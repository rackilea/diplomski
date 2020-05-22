public class Subject {

    private Observable<WordListUpateEvent> wordListObservable = new ObservableImpl<WordListUpateEvent>(); 

    //private Subject<OtherEvent> otherObservable = new ObservableImpl<WordListUpateEvent>();


    public ObservableRegistration<WordListUpateEvent> getWordListObservableRegistration() {
        return this.wordListObservable;
    }

//  public ObservableRegistration<OtherEvent> getOtherRegistration() {
//      return this.otherObservable;
//  }

    public void doSomething() {
        this.wordListObservable.notifyObservers(new WordListUpateEvent(42));
    }

}