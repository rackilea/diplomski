import java.security.SecureRandom;

public class Array_Generator {

    public static void main(String[] args) {

        int row = 5;
        int col = 5;
        String[][] grid = new String[row][col];
        String AB = "_W";
        SecureRandom rnd = new SecureRandom();
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder(row);
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(AB.charAt(rnd.nextInt(AB.length())));
                sb.toString();
                grid[i][j] = sb.toString();
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(""+grid[i][j]);
            }
            System.out.println();
        }

    }
}