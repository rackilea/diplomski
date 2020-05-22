while(!done) {
  if(sem.tryAcquire()) {
     // semaphore acquired
     done=true
  } else {
   // Semaphore not acquired, do something else
  }
}