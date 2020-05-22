Thread thread = new Thread(new Runnable() {
    public void run() {
        while(running) {
             String input;

             while((input = inputstream.readUTF()) != null) {
                  //handle input
             }
         }
    }
});