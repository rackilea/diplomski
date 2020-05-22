import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("data.txt"));
        String data = input.readLine();
        int sexIndex = 3;
        int yearIndex = 6;
        String femaleSex = "F";
        String year = "S3";
        int count = 0;
        while (data != null) {
            String[] chunks = data.split(",");

            if (chunks.length >= 6) { // to avoid IndexOutOfBoundException for invalid input
                if (chunks[sexIndex].equalsIgnoreCase(femaleSex) && chunks[yearIndex].equalsIgnoreCase(year)) {
                    count++;
                }
            }
            data = input.readLine();
        }

        if (count > 0)
        {
            System.out.println(" There are " +count+ " females are there in Year 3");
        }
        else
        {
            System.out.println("There are not females in Year 3");
        }
    }
}