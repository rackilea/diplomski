import java.util.*;

public class Listener {
   public static void main(String[] args) {
      AnimalSubject subject = new AnimalSubject("My Dog");

      DogObserver ozil = new DogObserver();

      ozil.getStatus();

      subject.addObserver(ozil);

      subject.setStatus(Status.AWAKE);
      subject.setStatus(Status.EATING);

      ozil.getStatus();

   }

}

class DogObserver implements Observer {
   private Status status = Status.ASLEEP;

   @Override
   public void update(Observable o, Object arg) {
      status = ((StatusEvent) arg).getNewValue();
      getStatus();
   }

   public void getStatus() {
      System.out.println("Status: " + status);
   }
}

class AnimalSubject extends Observable {
   private String name;
   private Status status = Status.ASLEEP;

   public AnimalSubject(String name) {
      this.name = name;
   }

   public void setStatus(Status status) {
      Status oldValue = this.status;
      Status newValue = status;
      if (oldValue.equals(newValue)) {
         return;
      }
      this.status = status;
      StatusEvent event = new StatusEvent(this, oldValue, newValue);
      setChanged();
      notifyObservers(event);
   }

   public Status getStatus() {
      return status;
   }

   public String getName() {
      return name;
   }
}


enum Status {
   ASLEEP, AWAKE, EATING
}

class StatusEvent {
   private Object source;
   private Status oldValue;
   private Status newValue;

   public StatusEvent(Object source, Status oldValue, Status newValue) {
      this.source = source;
      this.oldValue = oldValue;
      this.newValue = newValue;
   }

   public Object getSource() {
      return source;
   }

   public Status getOldValue() {
      return oldValue;
   }

   public Status getNewValue() {
      return newValue;
   }

}