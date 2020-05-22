import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bug {
    private int startingPoint;
    private char mrBug;
    private char placeholder;
    private int postition;
    private int matrixLength;
    private int matrixRows;
    private String lineGet;
    private String txtFile;
    private char[][] Data = new char[5][];

    /**
    Constructs a computer class with title, days, time and room
     */
    public Bug(int initialPosition, char bug, String inputFile) {
        startingPoint = initialPosition;
        mrBug = bug;
        txtFile = inputFile;
    }

    public void matrixPrinter() {
        System.out.println("Data:");

        for (int row = 0; row < Data.length; row++) {
            for (int col = 0; col < Data[row].length; col++) {
                System.out.print(Data[row][col]);
            }
            System.out.print("\n");
        }

    }//End of matrixBuilder Method

    public void matrixBuilder() throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream(txtFile));

        matrixRows = 0;
        // We should also check that the number of lines in the file 
        // doesn't exceed the Data array size.
        while (in.hasNextLine() && matrixRows < Data.length) {
            lineGet = in.next();
            System.out.println("line["+ matrixRows + "]:" + lineGet);
            matrixLength = lineGet.length();
            Data[matrixRows] = new char[matrixLength];
            for (int i = 0; i < matrixLength; i++) {
                placeholder = lineGet.charAt(i);
                Data[matrixRows][i] = placeholder;

            }//End of For
            matrixRows++;
        }//End of While
        in.close();
    }//End of matrixBuilder Method

    /**
    Gets the title
    @return the title
     */
    public void turn() {
        //return title;
    }

    public void move() {
        // your work here
    }

    /**
    Gets Postition
    @return the postition
     */
    public int getPostion() {
        return postition;

    }
}