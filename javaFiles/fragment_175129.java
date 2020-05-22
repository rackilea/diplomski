public class MainForm {


public static void main(String[] args) {
    boolean[][] array = new boolean[][] {{false, false, true, false, false, false}, 
            {false, false, true, false, false, false}, 
            {false, false, true, false, false, false}, 
            {false, false, true, false, false, false}};

    boolean[] [] another = path(array, 0, 0, 3, 5);

    for (boolean[] bArray : array) {
        for (boolean b : bArray) {
            System.out.println(b);
        }
    }
    System.out.println("***********************");
    for (boolean[] bArray : another) {
        for (boolean b : bArray) {
            System.out.println(b);
        }
    }
}

public static boolean[][] path(boolean[][] open, int start_i, int start_j, int end_i, int end_j) {
    int n = open.length;
    boolean[][] openCopy = new boolean[n][n]; // make a copy of open

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            openCopy[i][j] = open[i][j];
        }
    }
    return findPath(openCopy, start_i, start_j, end_i, end_j);
}

public static boolean[][] findPath(boolean[][] openCopy, int start_i, int start_j, int end_i, int end_j) {
    boolean[][] path = new boolean[openCopy.length][openCopy[0].length];

    if (openCopy[start_i][start_j] == false) // return false if current position is not open
        return path;
    else
        openCopy[start_i][start_j] = false; // make current position false if not (to prevent infinite backtracking)

    if (start_i == end_i && start_j == end_j) // if end found return true
    {
        path[start_i][start_j] = true;
        return path;
    }

    path = findPath(openCopy, start_i + 1, start_j, end_i, end_j); // Move North
    path = findPath(openCopy, start_i, start_j + 1, end_i, end_j); // Move East
    path = findPath(openCopy, start_i - 1, start_j, end_i, end_j); // Move South
    path = findPath(openCopy, start_i, start_j - 1, end_i, end_j); // Move West

    return path;
}
}