class ParallelSum {
  public static long calcSum(long start, long end) {
      long total = 0;
      for(long i = start; i < end; i++) {
          total += i;
      }
      return total;
  }

  public static class CalculatorThread extends Thread {
     private long result = 0;
     private long start;
     private long end;
     public CalculatorThread(long start, long end) {
         this.start = start;
         this.end = end;
     }
     @Override
     public void run() {
         result = calcSum(start, end);
     }
     public long getResult() {
         return result;
     }
  }

  public static void main(String[] args) throws InterruptedException {
    int start = 1;
    int end = 100000;
    int endExcl = end + 1;

    CalculatorThread ct1 = new CalculatorThread(start, endExcl/2);
    CalculatorThread ct2 = new CalculatorThread(endExcl / 2, endExcl);

    ct1.start();
    ct2.start();

    ct1.join();
    ct2.join();

    System.out.println(ct1.getResult() + ct2.getResult());
  }
}