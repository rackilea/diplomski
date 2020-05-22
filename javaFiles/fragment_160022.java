ServerSocket fileSocket = new ServerSocket(p);
                boolean rdy = false;
                while (!rdy) {
                    Socket client = fileSocket.accept();
                    String fileName = "C:/" + args[2];
                    String cmd = fileName + "\n";

                    OutputStreamWriter sWriter = new OutputStreamWriter(client.getOutputStream());
                    sWriter.write(cmd, 0, cmd.length());
                    sWriter.flush();

                    DataInputStream inStream = new DataInputStream(client.getInputStream());

                    FileOutputStream fileStream = new FileOutputStream(fileName);

                    while(inStream.available()<4) {} //wait for the size of an int
                    int imagesize = inStream.readInt();

                    byte[] buffer = new byte[imagesize];

                    while(inStream.available()<imagesize) {} //wait for all the image data
                    inStream.readFully(buffer);
                    fileStream.write(buffer, 0, imagesize);
                    fileStream.flush();

                    ta.append("File transfered");

                    inStream.close();
                    fileStream.close();
                    rdy = true;
                }
                fileSocket.close();
                return;