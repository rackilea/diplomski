Object setLock = new Object(); // Put this in a scope where all threads can access it

void addToSet( T element ){
    synchronized(setLock) {
       //add it
   }
}

void printAllValues(){
   synchronized(setLock) {
       //print the values
   }
}