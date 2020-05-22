class Ex4 extends Runnable {
      @Override
      public void run(){
          int newValue = ++UnSyncRead.value;
          System.out.println("changed the value to "+newValue);
      }
}
// and the same for the other runnables