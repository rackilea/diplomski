public class KnightChessRiddle {

    private final static Map<Integer, Character> letters = new HashMap<>();

    static {
        letters.put(0, 'a');
        letters.put(1, 'b');
        letters.put(2, 'c');
        letters.put(3, 'd');
        letters.put(4, 'e');
        letters.put(5, 'f');
    }

    public static void main(String[] args) {
        if (recursive(0, 0, 0, new boolean[6][6], 1, "")) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static boolean allVisited(boolean[][] positionsVisited) {
        for (int i = 0; i < positionsVisited.length; i++) {
            for (int j = 0; j < positionsVisited.length; j++) {
                if (!positionsVisited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean recursive(int positionX, int positionY, int moveType,
            boolean[][] positionsVisited, int moveCounter, String currentMoves) {

        // checks
        if (allVisited(positionsVisited)) {
            System.out.println(currentMoves);
            return true;
        }

        if (positionX > 5 || positionX < 0 || positionY > 5 || positionY < 0) {
            return false;
        }

        if (positionsVisited[positionX][positionY]) {
            return false;
        }

        // make move
        positionsVisited[positionX][positionY] = true;

        char c = letters.get(positionX);
        currentMoves += "" + c + (positionY + 1) + " (move type: " + (moveType + 1) + ")\r\n";

        if (recursive(positionX + 2, positionY + 1, 1, cloneArray(positionsVisited), moveCounter + 1, currentMoves)) {
            return true;
        } else if (recursive(positionX + 1, positionY + 2, 2, cloneArray(positionsVisited), moveCounter + 1, currentMoves)) {
            return true;
        } else if (recursive(positionX + 2, positionY - 1, 3, cloneArray(positionsVisited), moveCounter + 1, currentMoves)) {
            return true;
        } else if (recursive(positionX + 1, positionY - 2, 4, cloneArray(positionsVisited), moveCounter + 1, currentMoves)) {
            return true;
        } else if (recursive(positionX - 2, positionY + 1, 5, cloneArray(positionsVisited), moveCounter + 1, currentMoves)) {
            return true;
        } else if (recursive(positionX - 1, positionY + 2, 6, cloneArray(positionsVisited), moveCounter + 1, currentMoves)) {
            return true;
        } else if (recursive(positionX - 2, positionY - 1, 7, cloneArray(positionsVisited), moveCounter + 1, currentMoves)) {
            return true;
        } else if (recursive(positionX - 1, positionY - 2, 8, cloneArray(positionsVisited), moveCounter + 1, currentMoves)) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean[][] cloneArray(boolean[][] src) {
        boolean[][] newPositions = new boolean[src.length][src.length];
        for (int i = 0; i < src.length; i++) {
            System.arraycopy(src[i], 0, newPositions[i], 0, src[0].length);
        }
        return newPositions;
    } 
}