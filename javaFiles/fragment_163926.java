public static void main(String[] args) {
    System.out.println ("Players Board");


    char [][] grid = new char [10][10];
    for(int outerLoopValue = 0; outerLoopValue<10;outerLoopValue++)
    {

        for(int innerLoopValue = 0; innerLoopValue<10;innerLoopValue++)
        {
            grid[outerLoopValue][innerLoopValue]='O';
        }

    }
    printGrid(grid); // Note the change here
    Scanner sc =new Scanner(System.in);
    System.out.println("Please Choose the Co-ordinates of your first ship");
    System.out.println("X = ");
    int x = sc.nextInt();
    System.out.println("Y = ");
    int y = sc.nextInt();

    grid[x][y] = 'S';
    printGrid(grid); // Note the change here!
}

public static void printGrid(char[][] grid) {
    for(int outerLoopValue = 0; outerLoopValue<10;outerLoopValue++)
    {
        System.out.println("");
        for(int innerLoopValue = 0; innerLoopValue<10;innerLoopValue++)
        {
            System.out.print(grid[outerLoopValue][innerLoopValue]+"  ");
        }
    }
}