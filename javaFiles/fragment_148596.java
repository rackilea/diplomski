public void serialEvent(SerialPortEvent Ack_Rec) {


        if (Ack_Rec.getEventType() == SerialPortEvent.DATA_AVAILABLE) {

            try {

                while (in.available() > 0) {
                  int totalbytesreceivedinSession = in.read(sessionRead);

                    for (int bytesreceieved = 0; bytesreceieved < totalbytesreceivedinSession; bytesreceieved++) {

                        temporaryPacket[recDataCount++] = sessionRead[bytesreceieved];
                    } 
                    if(recDataCount == 1000){
                      //Process the data 
                      }
            }