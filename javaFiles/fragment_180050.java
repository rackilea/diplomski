public void saveSongsToPlayList(View view){
                try {
                   Firebase firebase = new Firebase("https://your-firebase-id.com").child("a44f757c1f96ac85").child("LZIZ......").child("playListName").child("NewSong")  
                   Firebase song1 = firebase.child("song")
                   song1.setValue("link to song or whatever")
                }catch (Exception ex){
                    ex.printStackTrace();
                }
        }