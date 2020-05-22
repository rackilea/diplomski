public void serialEvent(SerialPortEvent event){
            switch(event.getEventType()) {

                case SerialPortEvent.DATA_AVAILABLE:
                    byte[] readBuffer = new byte[8];


                    try {
                         while (inputStream.available()>0) {
                             int numBytes = inputStream.read(readBuffer);
                             peso += new String (readBuffer, 0, numBytes, "UTF-8").replaceAll("\\s+","").replaceAll("\\n", "").replaceAll("\\r", "");

                         }
                    } catch (IOException ex) {}

                    break;

            } 
    }