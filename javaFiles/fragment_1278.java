if (((Act) event.getTarget()).enabled) {
     if (event.getTarget().getName().equals("btnRestart")) {
            counter++;
            loadScreen("game");
            // show AdMob Interstitial
            if(counter%3==0) 
              nativePlatform.admobInterstitial();
            return;
     }
    ....
}