public class PowersOfTwo {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]); // last power of two to print
        int v = 1; // current power of two
        for (int i = 0; i <= N; i ++) {
            System.out.println(i + " " + v);    
            //i = i + 1; // you dont need this line
            v = 2 * v;
        }
    }
}