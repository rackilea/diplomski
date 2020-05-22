public synchronized boolean store ( int num) {    
   if (  items  < capacity ) {
       items ++;
       return true;
    }
    return false;
}