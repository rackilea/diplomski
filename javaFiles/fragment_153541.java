public final class Outer {
    private final List<Inner> history = new ArrayList<>(); //history is inverted for brevity, 0 is the latest one

    public Outer(int x) {
       this.history.add(new Inner(x));
    } 
    public void add(int x) {
      history.add( 0, new Inner(history.get(0).x+x);
    }

    public Inner current() {
       return history.get(0);
    }

    public static final class Inner {
       private final int x;

       private Inner(int x) {
          this.x = x;
       }

       public int getX() {
         return x;
       }
    }
}