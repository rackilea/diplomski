int myread(int fd) {
    FDSET fdset = ...;
    while (at least one byte read or error) {
       add fd to fdset 
       select(fdset) 
       if (read events) {
          do real read 
          return;
       }else {
          if (timeout) {
             check global/object level interrupt flag 
             if (set interrupt flag) {
                return;
             }
          }
       }
    }
}