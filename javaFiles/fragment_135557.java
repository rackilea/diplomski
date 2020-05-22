// Withing main thread start generating of x lines into pos OutputStream
generateLines(50000, pos);
// Spawn new thread within which we consume pipe from its InputStream end
Executors.newCachedThreadPool().submit(() -> {
   pis.read();
   // The rest of "reading-loop" omitted for sake of simplicity...
});