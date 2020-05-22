public class USBRunnable implements Runnable {

  public void run() {
      while (isRunning) {
          data = readFromUSBDevice();  // waits until data is available, returns the data read
          processData(data);
      }
   }
}