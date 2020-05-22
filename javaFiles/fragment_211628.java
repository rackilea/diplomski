try {
                //get UID cmd apdu
                 ResponseAPDU answer = cc.transmit( new CommandAPDU(new byte[] { (byte)0xFF, (byte)0xCA, (byte)0x00, (byte)0x00, (byte)0x00 } ));

                   System.out.println("answer: " + answer.toString());

                   byte[] reponseBytesArr=answer.getBytes();

                   System.out.println("answer byte[]");
                   StringBuilder sb = new StringBuilder();

                   for(int i=0;i<reponseBytesArr.length;i++){
                       //print arr
                       byte b =reponseBytesArr[i];
                       System.out.println(b);
                       if(i<=reponseBytesArr.length-3){
                        // append uid
                       sb.append(String.format("%02X ", b));
                       }
                }    
                    System.out.println("UID: "+sb.toString());