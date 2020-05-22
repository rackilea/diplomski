public void foo() {
  while( mTriCount <= 1 ) {
    for (int i = 0; i <toss.length; i++){
       toss[i] = randC.nextInt(4)+6;
    }
    mHex[mTriCount]=(a.evaluateTrigram(toss));
    mChangingHex[mTriCount] = (a.evaluateTrigram(toss));

    if (a.checkChangingLines()){
      a.changingLines(toss);
      a.evaluateTrigram(toss);
      changingTri++;
      mChangingHex[mTriCount] = a.evaluateTrigram(toss);
    }
    mTriCount++;
  }

  if ( changingTri > 0) {
    //do stuff
  }
}