private volatile boolean running = true;

public void Terminate() {
    running = false;
}

public void run(){
   while(running){
       try{
    String file="E://Net Beans Work Space//The Imran's Regression"
            + "//src//imranregression//audio//iron man.mp3";
         fis= new FileInputStream(file);
         bis= new BufferedInputStream(fis);
        playplayer = new Player(bis);



            playplayer.play();


}catch(Exception e){
    System.out.print("ERROR "+e);
}

   }