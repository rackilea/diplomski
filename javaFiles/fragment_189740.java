@Override
public void actionPerformed(final ActionEvent e) {

  //Initialise the serial port here before starting the new thread

  Runnable task = new Runnable() {

    @Override
    public void run() {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                inputLine = input.readLine();
                System.out.println( inputLine );
                final Millisecond now = new Millisecond();
                series.add(new Millisecond(), Double.parseDouble(inputLine));  

            } catch (Exception e) {                             
            }
        }
    }
  };
  Thread serialThread = new  Thread(task);
  serialThread.start();
}