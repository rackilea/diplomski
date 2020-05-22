if(event.getAction() == MotionEvent.ACTION_DOWN){
     pressTime = System.currentTimeMillis();
     if(releaseTime != -1l) duration = pressTime - releaseTime;
}
else if(event.getAction() == MotionEvent.ACTION_UP){
     releaseTime = System.currentTimeMillis();
     duration = System.currentTimeMillis() - pressTime;
}