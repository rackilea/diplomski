long start = System.nanoTime();
long totalRead = 0;
final double NANOS_PER_SECOND = 1000000000.0;
final double BYTES_PER_MIB = 1024 * 1024;

while ((val = bis.read(buffer, 0, 1024)) > 0) {
    //...
    totalRead += val;
    double speedInMBps = NANOS_PER_SECOND / BYTES_PER_MIB * totalRead / (System.nanoTime() - start + 1);
    double speedInMbps = speed * 8;
}