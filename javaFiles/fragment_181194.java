A: int current = get();  // current = 5
B: int current = get();  // current = 5
B: int next = current + delta;  // next = 6
B: if (compareAndSet(current, next))  // OK
          return next;
A: int next = current + delta;  // next = 6 
A: if (compareAndSet(current, next))  
    // fails, because "current" is still 5
    // and that does not match the value which has been changed to 6 by B