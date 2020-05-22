static public <T> void print(T... ts) {
    for (T t : ts) {
      System.out.print(t + " ");
    }
    System.out.println("");
}