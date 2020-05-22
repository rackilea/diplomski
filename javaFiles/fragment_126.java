Phaser phaser = new Phaser(n);

public void doWorkAndAwait(){
   //work
   phaser.arriveAndAwaitAdvance(); //await for all threads to arrive
}