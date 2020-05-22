Iterator<Blob> itr = list.iterator();
while( itr.hasNext() ) {
    Blob b = itr.next();
    if( /* test condition */ ) {
        itr.remove();  // Safely removes object from List during iteration
    }
} // Object `b` goes out of scope, and so this Blob is "lost" to the the code and is going to be destroyed