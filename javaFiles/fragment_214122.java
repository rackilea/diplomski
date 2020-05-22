private void initialize() {
 programButtonAnimation=new AnimationTimer(){

            private long lastUpdate = 0 ;
            @Override
            public void handle(long now) {
                    if (now - lastUpdate >= 28_000_000) {
                        showClockAnimation();
                        lastUpdate = now ;
                    }
            }
        };
 programButtonAnimation.start();
}

private void showClockAnimation(){
    String imageName = "%s_"+"%05d"+".%s";
    String picturePath="t093760/diploma/view/styles/images/pink_frames/"+String.format( imageName,"pink" ,frameCount,"png");
    programButton.setStyle("-fx-background-image:url('"+picturePath+"')");
    frameCount++;
    if(frameCount>=120){
        programButtonAnimation.stop();
        frameCount=0;
    }
}