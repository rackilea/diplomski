// You'll need to create this somewhere else, in your constructor
// or some other routine that gets called once.
ReentrantLock lock = new ReentrantLock(); 


// Then when you want to access:
lock.lock();
try {
 ... // do stuff with the data
}
finally {
  lock.unlock();
}