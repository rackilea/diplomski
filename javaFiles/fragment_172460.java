static int fileRunning = 0;

     public void playMp3(FileInputStream file) throws JavaLayerException{

         if (fileRunning == 0){

             mp3Player = new Player(file);

             playerThread = new Thread(this);
             playerThread.start();

             fileRunning = 1;

         }
     }