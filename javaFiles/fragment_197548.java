@Override
public void run() {
    // Always cancel discovery because it will slow down a connection
    //Log.d("workkkkkk","$$$$$$$$$$$$$$$$****** printingggggg ******$$$$$$$$$$$$$$$$");
    while (true) {
        //counter++;

        try {
            output = "";
            //read the data from socket stream
            //mmInStream != null && counter%10000000 == 1
            if(mmInStream != null) {
                mmInStream.read(buffer);
                for(byte b : buffer)
                {
                    char c = (char) b;
                    if(c >=' ' && c <'z') {
                        // System.out.print(c);
                        output += c;
                    }

                }
               // context == activity context
               context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // here do the UI chnages
                      //  you can set text in textview Here
                    }
                });


            }
            // Send the obtained bytes to the UI Activity
        } catch (IOException e) {
            //an exception here marks connection loss
            //send message to UI Activity
            break;
        }
    }

}