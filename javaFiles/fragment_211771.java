class Dummy {
    String a, b;
    public Dummy(String a, String b) {
        this.a = a;
        this.b = b;
    }
    public String toString(){
        return a+b;
    }
    public String getA() {
        return a;
    }
    public String getB() {
        return b;
    }
    public static Function<Dummy, String> getA = new Function<Dummy, String>() {
      public String apply(Dummy d) {
        return d.a;
      }
    }
    public static Function<Dummy, String> getB = new Function<Dummy, String>() {
      public String apply(Dummy d) {
        return d.b;
      }
    }
}