new Thread(new Runnable() {
    @Override
    public void run () {
        int counter = 0;
        while (true) {
            counter++;
            try {
                output = "";
                if (mInStream != null) {
                    mInStream.read(buffer);
                    for (byte b : buffer) {
                        char c = (char) b;
                        if (c >= ' ' && c < 'z') {
                            //System.out.print(c);
                            output += c;
                        }
                    }
                    //System.out.println();
                    Intent intent = new Intent();
                    intent.setAction("com.curie.WEIGHT_RECEIVED");
                    intent.putExtra("Output",output);

                    if (counter % 10 == 0) {
                        System.out.println(counter);
                        LocalBroadcastManager.getInstance(InputActivity.getContext()).sendBroadcastSync(intent);
                    }
                }
                // Send the obtained bytes to the UI Activity
            } catch (IOException e) {
                //an exception here marks connection loss
                //send message to UI Activity
                break;
            }
        }
    }
}).start();