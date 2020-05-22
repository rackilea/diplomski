try {
     while (true) {
        moveMap();
        if (!still)
           update(System.currentTimeMillis());
        Thread.sleep(13);
     }
  } catch (Exception e) {
     System.out.println("RUNTIME ERROR: " + e);
  }