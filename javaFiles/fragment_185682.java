import java.io.File;
import java.util.Scanner;
import java.text.DecimalFormat;
public class DartBoard
{

    public static void main(String[] args)
    {
        String fileName = "C:\\Users\\mikes\\Documents\\darts.txt";
        try {
            DartBoard db = new DartBoard(fileName);
            db.DisplayScores();
        } catch (Exception ex) {
            ex.printStackTrace();
        }                             
    }

    private double[][] darts;

    public DartBoard(String file) throws Exception {
        // we are going to read the file TWICE

        // figure out how many rows/cols we have:
        Scanner scan = new Scanner(new File(file));             
        int numberRows = 0;
        int numberCols = -1;
        while(scan.hasNextLine())
        {
            String row = scan.nextLine();
            numberRows++;
            String[] columns = row.split(" ");
            if (numberCols == -1)
            {
                numberCols = columns.length;
            }
            else if (columns.length != numberCols)
            {
                throw new IllegalArgumentException("Number of columns in each row does not match!");
            }
        }

        // instantiate the array and populate it:
        darts = new double[numberRows][numberCols];
        scan = new Scanner(new File(file));
        for(int i = 0; i < numberRows; i++){
            for(int j = 0; j < numberCols; j++){
                if(scan.hasNextDouble()){
                    darts[i][j] = scan.nextDouble();
                }
            }
        }
    }

    public void DisplayScores() throws Exception
    {
        if (darts != null)
        {
            int rows = darts.length;
            int cols = darts[0].length;
            if (cols % 2 == 0)
            {
                System.out.println("Scoring Results:");
                DecimalFormat f = new DecimalFormat("000");
                for(int r = 0; r < rows; r++)
                {
                    int player1Score = 0;
                    int player2Score = 0;
                    for(int c = 0; c < cols; c += 2)
                    {
                        if (c < cols / 2)
                        {
                            player1Score += score(darts[r][c], darts[r][c+1]);
                        }
                        else
                        {
                            player2Score += score(darts[r][c], darts[r][c+1]); 
                        }
                    }
                    String winner = (player1Score == player2Score ? "Tie" : player1Score > player2Score ? "One" : "Two");
                    System.out.println("Winner: Player " + winner + "  |  Player One Score: " + f.format(player1Score) + "  |  Player Two Score: " + f.format(player2Score));
                }
            }
            else
            {
                throw new IllegalArgumentException("Number of columns cannot be odd!");
            }
        }
        else
        {
            throw new IllegalArgumentException("No data to work with!");
        }
    }

    private double distance(double x, double y){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    private int score(double x, double y){
        double dist = distance(x,y);
        int s = 0;
        if(dist < 4){
            s = 100;
        } else if(dist < 8){
            s = 80;
        } else if(dist < 12){
            s = 60;
        } else if(dist < 16){
            s = 40;
        } else if(dist < 20){
            s = 20;
        }
        return s;
    }

}