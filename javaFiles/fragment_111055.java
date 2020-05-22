import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class StartThreads2 {
   public static void main(String[] args) {
      final MyVariables2 myVars2 = new MyVariables2();
      final RunOne runOne = new RunOne();
      final RunTwo runTwo = new RunTwo(myVars2);

      myVars2.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent pcEvt) {
            if (MyVariables2.START_APP.equals(pcEvt.getPropertyName())) {
               if (pcEvt.getNewValue().equals(Boolean.TRUE)) {
                  new Thread(runOne).start();
               }
            }
         }
      });

      new Thread(runTwo).start();
   }
}

class MyVariables2 {
   public static final String START_APP = "start app";
   private volatile boolean startApp = false;
   private PropertyChangeSupport pcSupport = new PropertyChangeSupport(this);

   public boolean isStartApp() {
      return startApp;
   }

   public void setStartApp(boolean startApp) {
      boolean oldValue = this.startApp;
      boolean newValue = startApp;
      this.startApp = startApp;
      pcSupport.firePropertyChange(START_APP, oldValue, newValue);
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(listener);
   }
}

class RunOne implements Runnable {
   @Override
   public void run() {
      System.out.println("Starting RunOne");
   }
}

class RunTwo implements Runnable {
   private static final int MAX_I = 10001;
   private MyVariables2 myVars2;

   public RunTwo(MyVariables2 myVars2) {
      this.myVars2 = myVars2;
   }

   @Override
   public void run() {
      for (int i = 0; i <= MAX_I; i++) {
         System.out.println("startApp: " + myVars2.isStartApp());
         System.out.printf("i: %05d%n", i);
      }

      myVars2.setStartApp(true);      
      try {
         Thread.sleep(10);
      } catch (InterruptedException e) {}
      System.out.println("startApp: " + myVars2.isStartApp());
   }
}