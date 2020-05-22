public static void drawGrid(char[][]){
             for(int outerLoopValue = 0; outerLoopValue<10;outerLoopValue++)
             {
                System.out.println("");
                for(int innerLoopValue = 0; innerLoopValue<10;innerLoopValue++)
                 {
                   System.out.print(grid[outerLoopValue][innerLoopValue]+"  ");
                 }

            }

}