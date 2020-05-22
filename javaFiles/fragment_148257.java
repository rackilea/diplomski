@Override
    public void onPause() {
        super.onPause();
        if(backgroundSoundService != null){
           backgroundSoundService.pause();
        }
    }