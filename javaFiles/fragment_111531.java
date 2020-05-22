checkIfSongPurhcased("songName", new OnQueryResultCallback(){
   public void onQueryResult(String songName, boolean status){
        if(status){
          // do something on success
        }else{
         // do something on failure
        }
   }
});