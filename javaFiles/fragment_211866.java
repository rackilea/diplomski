public void shuffle1(final MenuItem item, int startPosition, boolean playNow){
        mediaPlayer.stop();

        int position = this.position;
        if(playNow){
            position = startPosition;
        }
        switch(position){

            case 0:
                mediaPlayer  = MediaPlayer.create(this, R.raw.al098);
                break;
            case 1:
                mediaPlayer  = MediaPlayer.create(this, R.raw.al099);
                break;
            case 2:
                mediaPlayer  = MediaPlayer.create(this, R.raw.al100);
                break;
            case 3:
                mediaPlayer  = MediaPlayer.create(this, R.raw.al101);
                break;
        }
        if(!playNow){
            this.position++;
        }        
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                if(this.position == 4){
                    mediaPlayer.stop();
                    return;
                } else {
                    shuffle1(item, this.position, false);
                }
            }
        });

        mediaPlayer.start();
}