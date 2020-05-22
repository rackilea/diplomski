package stackOv;
import java.util.*;

abstract class Subject<T extends Subject<T>> {
  private List<Observer<T>> observers = new ArrayList<>();
  // returns a reference of this, of type T
  protected abstract T getThisSubject();
  protected void doNotify() {
    for(Observer<T> observer : observers) {
      observer.update(getThisSubject());
    }
  }
  public void addObserver(Observer<T> obs) {
    observers.add(obs);
  }
}

class SubjectA extends Subject<SubjectA> { 
  @Override
  protected SubjectA getThisSubject() {
    return this;
  }
}

interface Observer<T> {
  void update(T subject);
}

class UseSubject {
  public static void main(String[] args) {
    SubjectA sub = new SubjectA();

    Observer<SubjectA> obs = new Observer<SubjectA>() {
      @Override
      public void update(SubjectA subject) {
        //and here we have a reference to the right type
        System.out.println("subj=" + subject);
      }
    };

    sub.addObserver(obs);
    sub.doNotify();
  }
}