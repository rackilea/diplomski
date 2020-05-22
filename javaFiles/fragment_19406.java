public class TwoDimensionalStringArrayI {
    public static void main(String[] args) {
        String[][] b = {{"John", "Abby"},
                        {"Sally", "Tom"}};

//      System.out.println(firstRow(b)); // line 8
        String[] result = firstRow(b);
        for(int i = 0; i < result.length; i++)
            System.out.print(firstRow(b)[i] + " ");
    }

    public static String[] firstRow(String[][] a) {
        String[] name = new String[a[0].length];
        int counter = 0;

//      for (int row = 0; row < a.length; row++) {
        for (int row = 0; row < 1; row++) {
            for (int col = 0; col < a[row].length; col++) {
                name[counter++] = a[row][col]; // line 17
            }
        }
        return name;
    }
}