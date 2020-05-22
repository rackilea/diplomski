public class Sum implements Runnable {
   public void run() {
      //Add up your numbers
   }
}

public class Diff implements Runnable {
   public void run() {
      //Subtract numbers
   }
}


public class Test {
   public static void main(String[] args) {
      Thread sumThread = new Thread(new Sum());
      Thread diffThread = new Thread(new Diff());
      sumThread.start();
      diffThread.start();
   }
}