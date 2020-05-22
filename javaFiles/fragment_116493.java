public class FinishingLine {
  final BlockingQueue queue = new ArrayBlockingQueue(NUM_HORSES, true);

  public void arrive(Horse hourse) {
    queue.add(hourse);
  }
}