import java.util.Scanner;
public class TheGame {

    public static void main(String[] args) {
        {

            System.out.println("Players Board");

            char[][] grid = new char[10][10];
//FILL GRID//
            for (int outerLoopValue = 0; outerLoopValue < 10; outerLoopValue++) {

                for (int innerLoopValue = 0; innerLoopValue < 10; innerLoopValue++) {
                    grid[outerLoopValue][innerLoopValue] = 'O';
                }

            }
            //END OF FILL GRID//
            //DRAW GRID//
            drawGrid(grid);
            Scanner sc = new Scanner(System.in);
            System.out.println("");
            System.out.println("Please Choose the Co-ordinates of your first ship");
            System.out.println("X = ");
            int x = sc.nextInt();
            System.out.println("Y = ");
            int y = sc.nextInt();

            grid[x][y] = 'S';
            drawGrid(grid);

        }

    }


    //i am making a static method so it will be easy for 
    // you to call it from static method
    //Main method is static
    //else if you dont want it to be static than you have to
    //make object to the class to call this method
    //considering your beginner level i m making
    //this method static
    //Your question..
    /*
    why is there two public static void?
    */
    //The Answer is this we want to reuse the same code
    //public static void in most simple way 
    //you may call this as syntax[considering basic level]
    //void is class from java.lang 
    //if you keep on doing the same code in the
    //same method than you cannt reuse anything
    //and have to write same code again and again
    //for the same process
     public static void drawGrid(char[][] grid){
             for(int outerLoopValue = 0; outerLoopValue<10;outerLoopValue++)
             {
                System.out.println("");
                for(int innerLoopValue = 0; innerLoopValue<10;innerLoopValue++)
                 {
                   System.out.print(grid[outerLoopValue][innerLoopValue]+"  ");
                 }

            }

}
}