public class Map {
    private char[][] board;

    public Map(final char[] pTab1, final char[] pTab2, 
           final char[] pTab3, final char[] pTab4) {
        board = new char[4][4];

        for (int i = 0 ; i < 4 ; i++) {
            board[0][i] = pTab1(i);
            board[1][i] = pTab2(i);
            board[2][i] = pTab3(i);
            board[3][i] = pTab4(i);
        }
    }

    public boolean contains(String word) {
        char[] array = word.toCharArray();

        // empty string is trivial
        if (array.length == 0)
            return true;

        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == array[0] && findRecursively(i, j, array, 1))
                    return true;
            }
        }

        return false;
    }

    public boolean isValid(int i, int j) {
        return (0 <= i && i < 4) && (0 <= j && j < 4);
    }

    public boolean findRecursively(int i, int j, char[] array, int index) {
        // reached end of word
        if (index == array.length) {
            return true;
        } else {
            // loop over all neighbors
            for (int di = -1; di <= 1; di++) {
                for (int dj = -1; dj <= 1; dj++) {
                    // skip cell itself and invalid cells
                    if (!(di == 0 && dj == 0) && isValid(i+di, j+dj)) {
                        if (board[i+di][j+dj] == array[index] 
                              && findRecursively(i+di, j+dj, array, index+1))
                            return true;
                    }
                }
            }

            return false;
        }           
    }
}