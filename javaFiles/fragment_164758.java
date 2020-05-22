Thread fileTransferThread = new Thread(new Runnable(){
   public void run(){
        FileTransfer();
   }
});
fileTransferThread.start();