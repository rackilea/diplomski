public int nextWithTry() {
    try {
        //lock, exclusive access
        l.lock();
        //increment, all good
        c++; c++;
        //place the value of `c` to be returned on the stack (java passes by value)
        return c;
    } finally {   
        //unlock _after_ the return has been copied
        l.unlock();
    }
}