final double[] array;
 final int sizeMask;
 final AtomicInteger i = new AtomicInteger();

 public CircularBuffer(int size) {
      assert size > 1 && ((size & (size -1)) == 0); // test power of 2.
      array = new double[size];
      sizeMask = size -1;
 }

 void add(double value) {
     array[i.getAndIncrement() & sizeMask] = value;
 }