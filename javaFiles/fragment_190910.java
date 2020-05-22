import java.util.Random;
....


public static void main(String[] args) {
    char grid[][] = new char[20][40];
    Scanner move = new Scanner(System.in);
    Random rand = new Random();
    System.out.println("Let's start playing:");
    System.out.println("---------------------------------------------------------------");
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
            double r = rand.nextDouble();
            grid [i][j] = r < 0.025 ? '%' : r < 0.0625 ? '@' : '.';
            System.out.print(grid[i][j]);
        }
        System.out.println();
    }
}