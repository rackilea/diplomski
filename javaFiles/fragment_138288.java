public class Maze{

    private int maze[][] = new int[5][5];

    //Changing the value using initializer block
    {
        maze[1][1] = 1;
    }

    //Changing the value using constructor
    public Maze(){
        maze[1][1]=5;
    }

    public int[][] getMaze() {
        return maze;
    }

    public void setMaze(int[][] maze) {
        this.maze= maze;
    }

    public static void main(String args[]) {

        Maze maze = new Maze();
        int maze[][] = maze.getMaze();
        //Changing the value after creating object
        maze[1][2] = 5;
    }
}