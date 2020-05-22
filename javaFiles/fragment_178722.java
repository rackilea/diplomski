if(count < 3){
    Main_Sound_mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

        @Override
        public void onCompletion(MediaPlayer mp) {
            if(count <= 3){
            try {
                AssetFileDescriptor afd = getAssets().openFd(a[count]);
                if (Main_Sound_mediaPlayer.isPlaying()==true ){
                    Main_Sound_mediaPlayer.stop();}
                Main_Sound_mediaPlayer.reset();
                Main_Sound_mediaPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd .getLength());
                Main_Sound_mediaPlayer.prepare();
                Main_Sound_mediaPlayer.start();
            } 
            catch (IllegalArgumentException e) {  Toast.makeText(getApplicationContext(), e.toString() , Toast.LENGTH_SHORT).show();  } 
            catch (IllegalStateException e) {Toast.makeText(getApplicationContext(), e.toString() , Toast.LENGTH_SHORT).show(); } 
            catch (IOException e) { Toast.makeText(getApplicationContext(), e.toString() , Toast.LENGTH_SHORT).show();}
            }
            count++ ;
        }
    });
    if (flag == true) {
        try {
            AssetFileDescriptor afd = getAssets().openFd(a[count]);
            if (Main_Sound_mediaPlayer.isPlaying()==true ){
                Main_Sound_mediaPlayer.stop();}
            Main_Sound_mediaPlayer.reset();
            Main_Sound_mediaPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            Main_Sound_mediaPlayer.prepare();
            Main_Sound_mediaPlayer.start();
        } 
        catch (IllegalArgumentException e) {  Toast.makeText(getApplicationContext(), e.toString() , Toast.LENGTH_SHORT).show();  } 
        catch (IllegalStateException e) {Toast.makeText(getApplicationContext(), e.toString() , Toast.LENGTH_SHORT).show(); } 
        catch (IOException e) { Toast.makeText(getApplicationContext(), e.toString() , Toast.LENGTH_SHORT).show();}
        flag = false;
    }
    count++ ;
}else {
    if (Main_Sound_mediaPlayer.isPlaying()==true ){
        Main_Sound_mediaPlayer.stop();}
    Main_Sound_mediaPlayer.reset();
}