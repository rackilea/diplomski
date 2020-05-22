Handler handler2 = new Handler(Looper.getMainLooper());
handler2.postDelayed(() -> {  
    missileX = ufoX;
    resetRecent();
    waitForUfoTimer = false; 
  }
, randomize(20000, 18000));