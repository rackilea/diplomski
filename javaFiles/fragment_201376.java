try {
      work = queue.take();
      ...
  } catch (InterruptedException e) {
      // re-interrupt the thread which is always a good pattern
      Thread.currentThread().interrupt();
      // quit the processing thread
      return;
  }