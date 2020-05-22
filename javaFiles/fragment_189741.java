public synchronized void serialEvent(SerialPortEvent oEvent) {
    if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
        try {
            inputLine=input.readLine();
            System.out.println(inputLine);
            dataChart.addPoint(Double.parseDouble(inputLin));

        } catch (Exception e) {                             
        }
    }
}