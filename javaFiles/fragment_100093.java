import java.util.ArrayList;
import java.util.List;

public class Matrix {

    public static final int DOWN_RIGHT = 1;
    public static final int DOWN_LEFT = 2;
    public static final int UP_RIGHT = 4;
    public static final int UP_LEFT = 8;

    public String[] getMatrixDiagonal(String[] grid, int direction) {
        StringBuilder builder = new StringBuilder();
        for (String s : grid) {
            builder.append(s);
        }
        String matrixString = builder.toString();

        int wordLength = grid[0].length();
        int numberOfWords = grid.length;
        List<String> list = new ArrayList<String>();


        if (wordLength > 0) {
            int[] indexes = new int[numberOfWords];

            if (direction == DOWN_RIGHT) {
                indexes[0] = matrixString.length() - wordLength;
                for (int i = 1; i < numberOfWords; i++) {
                    indexes[i] = indexes[i - 1] - wordLength;
                }

                int wordCount = numberOfWords + wordLength - 1;

                for (int i = 0; i < wordCount; i++) {
                    builder.delete(0, builder.length());
                    for (int j = 0; (j <= i) && (j < numberOfWords); j++) {
                        if (indexes[j] < wordLength * (wordCount - i)) {
                            char c = matrixString.charAt(indexes[j]);
                            builder.append(c);
                            indexes[j]++;
                        }
                    }
                    String s = builder.reverse().toString();
                    list.add(s);
                }
            }

            if (direction == DOWN_LEFT) {
                // Exercise for original poster
            }

            if (direction == UP_RIGHT) {
                // Exercise for original poster
            }

            if (direction == UP_LEFT) {
                // Exercise for original poster
                // Same as DOWN_RIGHT with the reverse() removed
            }
        }

        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        String[] grid1 = { "SUGAR", "GLASS", "MOUSE", "STATE", "PUPIL", "TESTS" };
        String[] grid2 = { "SUGAR", "GLASS", "MOUSE" };

        Matrix matrix = new Matrix();
        String[] output = matrix.getMatrixDiagonal(grid1, DOWN_RIGHT);
        System.out.println(createStringLine(grid1));
        System.out.println(createStringLine(output));

        output = matrix.getMatrixDiagonal(grid2, DOWN_RIGHT);
        System.out.println(createStringLine(grid2));
        System.out.println(createStringLine(output));
    }

    private static String createStringLine(String[] values) {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");

        for (String s : values) {
            builder.append("\"");
            builder.append(s);
            builder.append("\" ");
        }

        builder.append("]");

        return builder.toString();
    }

}