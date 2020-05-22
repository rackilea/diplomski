import java.io.BufferedReader; 
import java.io.FileReader;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
class myRead{
    public static void main(String[] args) throws FileNotFoundException, IOException {
        long cnt = 0;
        long numberOfLines = 0;
        BufferedReader myReader = new BufferedReader(new FileReader("test.txt")); 
        String line = myReader.readLine();
            while(line != null){
                numberOfLines++;
                String[] parts = line.split(" ");
                cnt = cnt + Integer.parseInt(parts[3]);
                line = myReader.readLine();
            } 
        System.out.println("There are " + numberOfLines + " accounts that together hold " + cnt + " points.");
}
}