public synchronized deleteObject() {
  while( isEmpty() ) {
    try {
      wait();
    } catch( Exception ex ) {
      ex.printStackTrace();
    }//catch
  }//while

  //actually do delete object.
  ...
}//met