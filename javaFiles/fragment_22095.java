public MediaPlayer(URL mediaUrl) throws Exception{    

      try{
       UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
  }catch (ParseException | UnsupportedLookAndFeelException e) {    
          e.printStackTrace();      
  }

setLayout(new BorderLayout());

try {  
   mediaPlayer=Manager.createRealizedPlayer(new MediaLocator(mediaUrl));
   Component video=mediaPlayer.getVisualComponent();
   Component control=mediaPlayer.getControlPanelComponent();

   if (video!=null) {
           add(video, BorderLayout.CENTER);          // place the video component in the panel
              }
    add(control, BorderLayout.SOUTH);            // place the control in  panel

 //mediaPlayer.start();
 Thread.sleep(1000);

     } catch (IOException | NoPlayerException | CannotRealizeException | NullPointerException  e) {
 e.printStackTrace();
}

}
}