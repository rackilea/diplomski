import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class StackoverflowExample {

    private static final int INFORMATION_CAP = 100;
    private static String[][] INFORMATION = new String[INFORMATION_CAP][INFORMATION_CAP];

    public StackoverflowExample() {
        String currentLine;
        String[] textData;
        int lineID = 0;
        boolean endOfFile = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("textfile.txt"));
            currentLine = reader.readLine();
            while(!endOfFile && currentLine != null) {
                currentLine = currentLine.trim();
                textData = currentLine.split("\\t");
                String userType = textData[0];
                String year = textData[1];
                String name = textData[2];
                String age = textData[3];
                String profession = textData[4];
                String number = textData[5];
                INFORMATION[lineID] = new String[] { userType, year, name, age, profession, number };
                lineID++;
                currentLine = reader.readLine();
            }

        } catch (IOException e) { 
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StackoverflowExample();
        for(int i = 0; i < INFORMATION.length; i++) {
            System.out.println("Type: " + INFORMATION[i][0] +
                    "year: " + INFORMATION[i][1] + 
                    "name: " + INFORMATION[i][2] + 
                    "age: " + INFORMATION[i][3] + 
                    "profession: " + INFORMATION[i][4] +
                    "number: " + INFORMATION[i][5]);
        }
    }
}