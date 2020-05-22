public class Calculation {
    public static void main(String args[]) {
        int start = 870136 - 250;
        int end = 870385 - 250;

        for(int i=1; i<=2000; i=i+250) {
            start = start + 250;
            end = end + 250;

            System.out.println("(" + i + "-" + (i+250 - 1) + ")");
            System.out.println("START = " + start);
            System.out.println("END = " + end + "\n");
        }
    }
}