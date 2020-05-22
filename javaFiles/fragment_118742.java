{ // begin of the "block of code
  long t0 = System.currentTimeMillis();

  // code of the "block of code"

  long t1 = System.currentTimeMillis();
  long delta = 6000 - (t1 - t0);
  if( delta > 0 ){
      Thread.sleep( delta ); 
  }
  // end of the "block of code"
}