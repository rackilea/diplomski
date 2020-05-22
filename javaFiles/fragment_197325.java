public class Outer {

    public static class LineType {
        int id;
        String descr;

        private LineType( int a, String b) {
          this.id = a;
          this.descr = b;
        }
    }

    static LineType[] myList = { 
        new LineType( 1, "first" ),
        new LineType( 2, "second" ),
    };
}