private static void doUpdate(final Display display, final Label target,
      final String value) {
    display.asyncExec(new Runnable() {
      @Override
      public void run() {
        if (!target.isDisposed()) {
          target.setText(value);
          target.getParent().layout();
        }
      }
    });
  }