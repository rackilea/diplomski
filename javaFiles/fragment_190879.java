public static void main(String[] args) {
    int x, y;
    int[][] maze;
    try {
        Scanner reader = new Scanner(new File("C:\\Users\\User\\Desktop\\mazes\\input.txt"));
        x=reader.nextInt();
        y=reader.nextInt();
        maze = new int[x][y];
        for (int i=0; i<x; i++){
            for (int j=0; j<y; j++){
                maze[i][j]=reader.nextInt();
                System.out.println(maze[i][j]);
            }
        }       
        reader.close();
    } catch (FileNotFoundException e1) {
        System.out.println("Problem with the file");
        e1.printStackTrace();
    }
}