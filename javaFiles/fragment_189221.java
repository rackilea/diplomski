// Write byte arrays to this stream in the producer thread
PipedOutputStream os = new PipedOutputStream(); 

PipedInputStream in = new PipedInputStream(os);
// Read from this stream in the consumer thread
ZipInputStream zis = new ZipInputStream(in);