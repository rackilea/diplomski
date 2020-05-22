public synchronized void synch1() {
   // body
}
// equivalent to:
public void synch2() {
   synchronized( this ) {
      // body
   }
}