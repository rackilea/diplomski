mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { 
 @Override 
 public void onCompletion(MediaPlayer mp) 
 { 

    myMediaPlayer.reset(); 
   /* load the new source */ 
   myMediaPlayer.setDataSource(url[position]);//select the path according to your need 
   /* Prepare the mediaplayer */ 
   myMediaPlayer.prepareAsync();