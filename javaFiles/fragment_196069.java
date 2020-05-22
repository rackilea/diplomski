public class Example {

  interface Whiteboard {
    void visit();
  }

  static class Wrapper {
    Whiteboard  whiteboard;
    AtomicLong  averageTime = new AtomicLong();

    public Wrapper(Whiteboard whiteboard) {
        this.whiteboard = whiteboard;
    }

    void visit() {
        if (averageTime.get() < 100) {
            long start = System.currentTimeMillis();
            whiteboard.visit();
            long time = System.currentTimeMillis() - start;
            averageTime.getAndUpdate(v -> (99 * v + time) / 100);
        } else
            averageTime.getAndUpdate(v -> (99 * v) / 100);
    }
  }

  ServiceTracker<Whiteboard, Wrapper> tracker;

  @Activate
  void activate(BundleContext context) {
      tracker = new ServiceTracker<Whiteboard, Wrapper>(context,
            Whiteboard.class, null) {
        @Override
        public Wrapper addingService(
                ServiceReference<Whiteboard> reference) {
            return new Wrapper(context.getService(reference));
        }

        @Override
        public void removedService(ServiceReference<Whiteboard> reference,
                Wrapper service) {
            context.ungetService(reference);
        }
    };
    tracker.open();
  }

  void visit() {
    tracker.getTracked().values().forEach(wrapper -> wrapper.visit());
  }
}