public class StringToInt2dArray {

    public static void main(String [] args) {

        String s = "1 2 3 4 5 6 7 8 8 8 8 8 1 2 3 4";
        System.out.println("Input string: " + s);
        String [] ss = s.split(" ");
        System.out.println("Array of strings: " + Arrays.toString(ss));
        int [] int1d = new int [ss.length];
        for (int i = 0; i < ss.length; i++) {
            int1d [i] = Integer.parseInt(ss[i]);
        }
        System.out.println("Array of ints: " + Arrays.toString(int1d));

        int rows = 4;
        int cols = 4;
        int ints2d [][] = new int [rows][cols]; // need to know the 2d array size

        int n = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ints2d [i][j] = int1d [n++];
            }
        }

        System.out.println("Array of ints in 2D: ");
        for (int i = 0; i < ints2d.length; i++) {
            System.out.println(Arrays.toString(ints2d [i]));
        }
    }
}