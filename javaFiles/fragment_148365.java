class TestRunner
{
    public static void main(String[] args){
        GameOfLife gol = new GameOfLife(5, 3);
        System.out.println(gol.getColumns());
        System.out.println(gol.getRows());      
    }
}

class GameOfLife
{
    private boolean[][] society;

    public GameOfLife(int rows, int cols){
        society = new boolean[rows][cols];
    }

    public int getColumns(){
        return society[0].length;
    }

    public int getRows(){
        return society.length;
    }
}