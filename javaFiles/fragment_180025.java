if (hatPicture.isPointInElement(clickX, clickY)){
        bluntSoundPlay = false;
        weedSoundPlay = false;
        dealwithitSoundPlay = false;
        if (!hatSoundPlay) {
            hatsound.play(); 
            hatSoundPlay = true; 
        }
    } else if (bluntPicture.isPointInElement(clickX, clickY)){ 
        hatSoundPlay = false;
        weedSoundPlay = false;
        dealwithitSoundPlay = false;
        if (!bluntSoundPlay) {
            bluntsound.play(); 
            bluntSoundPlay = true;
        } 
    } else if (dealwithitPicture.isPointInElement(clickX,  clickY)){
         hatSoundPlay = false;
         bluntSoundPlay = false;
         weedSoundPlay = false;
         if (!dealwithitSoundPlay) {
             dealwithitsound.play(); 
             dealwithitSoundPlay = true;
         } 
    } else if (weedPicture.isPointInElement(clickX,  clickY)){ 
         dealwithitSoundPlay = false;
         hatSoundPlay = false;
         bluntSoundPlay = false;
         if (!weedSoundPlay) {
             weedsound.play(); //then weedsound will play
             weedSoundPlay = true;
         } 
    } else if (backgroundPicture.isPointInElement(clickX, clickY) { 
        if (hatSoundPlay){ 
            EZ.addImage("hat.png", clickX, clickY);
            hatsound.play();        
        } else if (bluntSoundPlay){
            EZ.addImage("blunt.png", clickX, clickY);
            bluntsound.play();
        } else if (dealwithitSoundPlay){
            EZ.addImage("dealwithit.png", clickX, clickY);
            dealwithitsound.play();
        } else if (weedSoundPlay){
            EZ.addImage("weed.png", clickX, clickY);
            weedsound.play();
        }
    }