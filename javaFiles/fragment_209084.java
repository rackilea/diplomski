final Runnable other = null;
    final Runnable example = new Runnable() {
      @Override
      public void run() {
        System.out.println(other);
      }
    };