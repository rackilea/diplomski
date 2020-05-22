public abstract class SimulatorRunnable extends Runnable {
     protected SimulatorInterface si;
     public SimulatorRunnable(SimulatorInterface si) {
         this.si = si;
     }
}

public final class Simulator extends SimulatorRunnable {
     public Simulator(SimulatorInterface si) {
         super(si);
     }
     public void run() {
         // here you can use the si
         si.simulate(...);
     }
}