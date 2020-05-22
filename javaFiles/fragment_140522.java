public class MyStockPanel extends JPanel {
  private final BlockingQueue<StockEvent> stockEvents;

  // Runnable invoked on event dispatch thread and responsible for applying any
  // pending events to the table model.
  private final Runnable processEventsRunnable = new Runnable() {
    public void run() {
      StockEvent evt;

      while ((evt = stockEvents.poll() != null) {
        // Update table model and fire table event.
        // Could optimise here by firing a single table changed event
        // when the queue is empty if processing a large #events.
      }
    }
  }

  // Called by thread other than event dispatch thread.  Adds event to
  // "pending" queue ready to be processed.
  public void addStockEvent(StockEvent evt) {
    stockEvents.add(evt);

    // Optimisation 1: Only invoke EDT if the queue was previously empty before
    // adding this event.  If the size is 0 at this point then the EDT must have
    // already been active and removed the event from the queue, and if the size
    // is > 0 we know that the EDT must have already been invoked in a previous
    // method call but not yet drained the queue (i.e. so no need to invoke it
    // again).
    if (stockEvents.size() == 1) {
      // Optimisation 2: Do not create a new Runnable each time but use a stateless
      // inner class to drain the queue and update the table model.
      SwingUtilities.invokeLater(processEventsRunnable);
    }
  }
}