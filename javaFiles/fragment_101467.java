public class ModelA extends Observable {

   public void notify() {
       this.setChanged();
       this.notifyObservers(new ArrayList<A>());
   }
}

public class ModelB extends Observable {

   public void notify() {
       this.setChanged();
       this.notifyObservers(new ArrayList<B>());
   }
}