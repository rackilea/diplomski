// in add etc.
notEmpty.signal();

// in take()
while(count == 0) 
  notEmpty.await();