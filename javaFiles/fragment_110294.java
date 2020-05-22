public void nestedLoop(int size, int loopSize) {
    int[] i = new int[size];
    while (i[size-1] < loopSize) {
       doSomethingWith(i);
       increment(i, loopSize);
    }
}

public void increment(int[] i, int maxSize) {
   int idx = 0;
   while (idx < i.length) {
      if (++i[idx] < maxSize) {
         return;
      }
      i[idx++] = 0;
   }
}