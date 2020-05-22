while (staticInt >= MAX_NUMBER_OF_THREADS) {
     //wait
 }

 synchronized(staticInt) {
    //create AsyncTask
    ++staticInt;
 }