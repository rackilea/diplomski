> Try something like:

      void beginListenForData() {
        final Handler handler = new Handler();
        stopThread = false;
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (!Thread.currentThread().isInterrupted() && !stopThread) {
         try {
                            byte[] buffer = new byte[1];
                            bytes = mmInStream.read(buffer, 0, 1);
                            String read = new String(buffer, 0, 1);
                            readMessage.append(read);
                            if (buffer[0] == '}') {
                                bytes = mmInStream.read(buffer, 0, 1);

                                    readMessage.append(read);
      String readMessage1 = new String(buffer,   
                                                              0, bytes, "US-ASCII");
                                            Log.e("bytes ",  
                                                  Integer.toString(bytes));

                                            sendMessage(readMessage);

                                        } catch (IOException e) {
                                            e.printStackTrace();
                                            Log.e("tag", "failed");
                                        }



                                }
                            });

                        }
                    } catch (IOException ex) {
                        sendMessage("F");
                        stopThread = true;
                    }
                }
            }
        });

        thread.start();
    }