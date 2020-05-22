// fields
Object playerStopEvent = new Object();
boolean isPlaying;

// in your media player, when playback is complete:
synchronized (playerStopEvent) {
   isPlaying = false;
   playerStopEvent.notifyAll();
} 

// elsewhere, when waiting for playback to complete:
synchronized (playerStopEvent) {
   while (isPlaying) {
       try {
           playerStopEvent.wait();
       } catch (InterruptedException x) {
           // abort or ignore, up to you
       }
    }
}
mediaPlayer.stop();