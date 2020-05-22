public int next(){
    //lock, exclusive access
    l.lock();
    //increment, all good
    c++; c++;
    //unlock, another thread can access
    l.unlock();

    //any number of other threads call `next` and can acquire the lock

    //return some random value
    return c;
}