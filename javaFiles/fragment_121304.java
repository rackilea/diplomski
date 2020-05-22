InputStream dataIn = CommandHandler.getdatain();
                 OutputStream dataOut = CommandHandler.getdataout();
                 //dataOut.write(command.getBytes()+"\n");
                 byte[] inputbytes = command.getBytes();
                 dataOut.write(inputbytes,0,inputbytes.length);
                 dataOut.flush();
                 while (true) {
                        boolean readoutput=false;
                        while (dataIn.available() > 0) {
                            readoutput=true;
                            byte[] buffer=new byte[1024];
                            int i = dataIn.read(buffer, 0, 1024);
                            if (i < 0) {
                                System.out.print("No more data available!");//It is printing the response to console
                                break;
                            }
                            LogText.append(new String(buffer, 0, i));
                            //LogText.append(":"+new String(buffer, 0, i)+"\n>");
                            System.out.print(new String(buffer, 0, i));//It is printing the response to console
                        }
                        System.out.println(dataIn.available()+"done");
                        if ( readoutput )
                        {
                            if ( dataIn.available() == 0 )
                            {
                                System.out.print("Read all the data and no nore is available, hence exiting!\n");//It is printing the response to console
                                break;
                            }
                        }
                        if ( channel.isClosed() ) {
                            System.out.println("exit-status: " + channel.getExitStatus());
                            break;
                        }
                        try{Thread.sleep(1000);}catch(Exception ee){}
                 }