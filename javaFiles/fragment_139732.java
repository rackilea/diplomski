MyObject ref = null;
try {
    // get a reference, increment counter
    ref = MyObject.getReference(args);
    ...
} finally {
     // decrement counter, promising to drop reference
     if (ref != null) {
         ref.release();
         ref = null;
     }
}