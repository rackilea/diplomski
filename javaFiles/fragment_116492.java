public class FinishingLine {
    List arrivals;
    final Semaphore semaphore = new Semaphore(1, true);

    public FinishingLine() {
        arrivals = new ArrayList<Horse>();
    }

    public void arrive(Horse hourse) {
        semaphore.acquire();
        try {
          arrivals.add(hourse);
        } finally {
          semaphore.release();
        }
    }
}