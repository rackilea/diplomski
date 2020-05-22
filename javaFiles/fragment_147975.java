enum RunOne {; // no instances
      static final ExecutorService service = Executors.newSingleThreadedExecutor();
      static Future last = null;

      static synchronized void run(Runnable run) {
          if (last != null && !last.isDone()) return;
          last = service.submit(run);
      }
 }