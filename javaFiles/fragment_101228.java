import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.File;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.Random;


    public class Demo1 {

        public static String getRandomNumber() {

            String CHARS = "1234567890";
            StringBuilder random = new StringBuilder();
            Random rnd = new Random();
            while (random.length() < 18) // length of the random string.
            { 
                int index = (int) (rnd.nextFloat() * CHARS.length());
                random.append(CHARS.charAt(index));
            }
            String finaldata = random.toString();
            return finaldata;
        }

        public static void main(String[] args) throws IOException {
            File sourceCsvFile = null;
            File finalCsvFile = null;
            // String sourceCsvFileName = "";
            sourceCsvFile = new File("C:\\MyData\\Input.csv");
            finalCsvFile = new File("C:\\MyData\\Input_1.csv");
            String line = "";
            String cvsSplitBy = ",";



            BufferedWriter writer = new BufferedWriter(new FileWriter(finalCsvFile));


            try (BufferedReader br = new BufferedReader(new FileReader(sourceCsvFile))) // read the actual Source downloaded csv file
            {
                line = br.readLine();  // read only first line
                String newFileLine = line + cvsSplitBy  + "HashValue";  // append "," and new column <HashValue>
                writer.write(newFileLine);   // will be written as first line in new csv
                writer.newLine();  //  go to next line for writing next lines


                while ((line = br.readLine()) != null)  // this loop to write data for all lines except headers
                {

                    newFileLine = line + cvsSplitBy  + getRandomNumber();  // will add random numbers for each row

                    writer.write(newFileLine);
                    writer.newLine();

                }

            }

            writer.close();



            if(finalCsvFile.exists() && finalCsvFile.length() > 0)
            {
                System.out.println("New File with HashValue column created...");
                if(sourceCsvFile.delete()) 
                { 
                    System.out.println("Old File deleted successfully..."); 
                }

                else
                { 
                    System.out.println("Failed to delete the Old file..."); 
                } 
            }

            else if (!finalCsvFile.exists())
            {
                System.out.println("New File with HashValue column not created...");
            }




        }
    }