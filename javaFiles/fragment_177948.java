public void serialEvent(SerialPortEvent oEvent) {
    if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
        try {
            String inputLine=null;
            if (input.ready()) {
                inputLine = input.readLine();
                            System.out.println(inputLine);
                            // DO SOMETHING WITH THE inputLine RECEIVED HERE 
                            // EG. PASS IT TO SOME OTHER SERVICE METHOD

            }

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}