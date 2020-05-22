public void songPicked(View view)
    {  
       if(view.getTag().toString() != null){
          int songIndex = Integer.parseInt(view.getTag().toString());
        }
        musicService.setSong(songIndex);
        musicService.playSong();
        if(playbackPaused){
            setController();
            playbackPaused = false;
        }
        controller.show(0);
    }