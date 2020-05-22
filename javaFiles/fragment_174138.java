package rotation.pkg45;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Rotation45 {
    public static void main(String[] args) throws IOException {
        String filename = "bank-full2.csv";
        File file = new File(filename);
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("bank2test1.csv"));

            Scanner inputStreamm = new Scanner(file);
            inputStreamm.nextLine();

            while (inputStreamm.hasNext()) { // while loop for find MEAN
                String data = inputStreamm.nextLine(); // read each line and store in data
                String[] values = data.split(","); // every line splited with " , " and store each attribute in string list

                // double value is generating 34.0 value, and you are expecting only 34
                // double first = Double.parseDouble(values[1]);
                int first = Integer.parseInt(values[1]);
                first = first + 2;

                values[1] = String.valueOf(first);
                StringBuilder sb = new StringBuilder();
                // String newData = sb.toString();
                for (int i = 0; i < values.length; i++) {
                    sb.append(values[i]);
                    if (i < values.length - 1) {
                        sb.append(",");
                    }
                }

                if (inputStreamm.hasNext()) { /* To handle NoSuchElementException */
                    String data1 = inputStreamm.nextLine(); // read each line and store in data
                    String[] values1 = data1.split(",");

                    // double second = Double.parseDouble(values1[1]);
                    int second = Integer.parseInt(values1[1]);
                    second = second + 1;
                    values1[1] = String.valueOf(second);

                    sb.append("\n");
                    for (int i = 0; i < values1.length; i++) {
                        sb.append(values1[i]);
                        if (i < values.length - 1) {
                            sb.append(",");
                        }
                    }
                }
                writer.write(sb.toString() + "\n");
            }
            writer.close();

            inputStreamm.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Rotation45.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}