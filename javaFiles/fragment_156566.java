boolean isOutOfMemory = false;

try{
    // Your Code here.
    }catch (OutOfMemoryError ex) {
        System.gc();                // clean up largeVar data
        isOutOfMemory = true;       // flag available for use
    }