public class Points {

    public static void points(int d) {
        int px = d;
        int py = 0;
        int dx = -1, dy = 1;
        int n = d * 4;
        for( int i = 0; i < n; i++ ) {
            if( px == d && dx > 0 ) dx = -1;
            else if( px == -d && dx < 0 ) dx = 1;
            if( py == d && dy > 0 ) dy = -1;
            else if( py == -d && dy < 0 ) dy = 1;
            px += dx;
            py += dy;
            doSomething(px, py);
        }
    }

    private static void doSomething(int px, int py) {
        System.out.printf("(%2d,%2d)\n", px, py);
        // do whatever you need 
    }

    public static void main(String[] args) {
        points(2);
    }
}