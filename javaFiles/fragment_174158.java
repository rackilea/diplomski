public class matrixRec {
    public static void main(String[] args) {
        char[][] matrix = {
            {' ',' ',' ',' ',' ',' '},
            {' ','h','h','h','h',' '},
            {' ',' ',' ',' ',' ',' '},
            {' ',' ',' ','#','#',' '},
            {' ','h',' ',' ','#','#'},
            {' ','h','#',' ',' ',' '}
        };
        boolean visited[][] = new boolean[6][6] //boolean arrays default to false
        System.out.println(elementChange(matrix, 1, 2, visited));
    }
    static boolean elementChange(char[][] matrix, int y, int x. boolean[][] visited){
        if(visited[y][x]) return ((matrix[y][x] == ' ' || matrix[y][x] == 'h')? true: false);
        visited[y][x] = true; //We have visited this cell
        if (matrix[y][x] == ' '){
            return true;
        }
        else if (matrix[y][x] == '#'){
            return false;
        }
        else if (matrix[y][x] == 'h'){
            return elementChange(matrix, y, x-1,visited) && elementChange(matrix, y, x+1,visited) && elementChange(matrix, y-1, x,visited) && elementChange(matrix, y+1, x,visited);
        }
        else {
            return false;
        }
    }
}