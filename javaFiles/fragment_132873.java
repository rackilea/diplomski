while (barrier.getNumberWaiting() != this.threadNumber) {
}

// Do your adding to the StringBuilder here...

barrier.await();