public class XXX extends Observable implements SerialPortEventListener {

    int[] val = new int[2];

    public synchronized void serialEvent(SerialPortEvent oEvent) {
        String storeId;
        String status; 
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                // all your code here
                setChanged();
                notifyObservers();
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }  
    }

    ...
}