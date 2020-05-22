public static void speakToPerson2() {
    try {
      speakToPerson1();
    } catch (Exception e) {
      System.out.println("speakToPerson2 caused exception");
      e.printStackTrace();
      throw e;
    }
  }

  public static void speakToPerson3() {
    try {
      speakToPerson2();

    } catch (Exception e) {
      System.out.println("speakToPerson3 caused exception");
      e.printStackTrace();
      throw e;
    }
  }