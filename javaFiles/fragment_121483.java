// Check the timer
if (timer.isFinished()) {
  if (totalDrops < drops.length) {
    drops[totalDrops] = new Drop(); 

    totalDrops++;
  }
  timer.start();
}