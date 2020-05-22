public class Printing  implements Printable, ActionListener {
static String str = "";

    public String printString(char [][] grid ){  
        for(int i=0;i<9;i++){
            for (int j=0;j<9;j++){    
                str += String.valueOf(grid[i][j]);
            }
            str += "\n";
        } 
        return str;
    }
}