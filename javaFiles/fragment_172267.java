for (int i = 0; i < 4; i++) { // 4 THREADS AT ONCE
  final int temp=i;
  thread[i] = new Thread() {
    public void run() {
      randomMethod(temp); // ERROR HERE
    }
  };
  thread[i].start();
}