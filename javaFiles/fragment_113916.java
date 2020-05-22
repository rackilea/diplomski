public class PowersOfTwo {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]); // last power of two to print
        int v = 1; // current power of two
        for (int i = 0; i <= N;) { //no need to i++
            System.out.println(i + " " + v);    
            i = i + 1; 
            v = 2 * v;
        }
    }
}