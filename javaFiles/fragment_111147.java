OnClickListener(View view){
    //use the same instance of mediaplayer and call mp.start();
    if(isPlaying){
       mp.pause();
    }else{
    mp.start();
 }
}