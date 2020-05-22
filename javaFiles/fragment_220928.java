import java.util.Arrays;

public class RowCompare
{
    public static void main(String[] args)
    {
        String[] row1 = new String[10];
        String[] row2 = new String[10];
        String[][] fruit = {{"apple", "banana", "kiwi"},{"kiwi", "oranges", "grapes"}};

        for (int i = 0; i < fruit[0].length; i++ ) {
            for (int j = 0; j < fruit[1].length; j++){
                    if(fruit[0][i].equals(fruit[1][j])) {
                        row1[i] = fruit[0][i];
                        row2[j] = fruit[1][j];

                        System.out.println("Match found");
                    }else{
                        System.out.println("Not found");
                    }
            }
        }
        System.out.println("row1");
        System.out.println(Arrays.deepToString(row1));
        System.out.println("row2");
        System.out.println(Arrays.deepToString(row2));
    }
}