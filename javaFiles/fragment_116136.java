public class textFileIO {
    public static void main(String[] args) throws Exception {
        //Clear the contents of numbers.dat if already exists and populated
        File fileOne = new File("numbers.dat");
        fileOne.delete();
        File newFile = new File("numbers.dat");
        newFile.createNewFile();
        //Create writer object
        PrintWriter writer = new PrintWriter(new FileWriter("numbers.dat"));
        //Loop from 1 to 100
        for (int i = 1; i <= 100; i++) {
            //If number is even, write to file  
            if (i % 2 == 0) {
                writer.print(i + ",");
            }
        }
        //Close writer object.
        writer.close();
        //Read from file
        FileInputStream fileStream = new FileInputStream("numbers.dat");
        DataInputStream in = new DataInputStream(fileStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        //Print line
        System.out.println(reader.readLine());
        reader.close();
        //Write all odd numbers to file
        PrintWriter writer2 = new PrintWriter(new FileWriter("numbers.dat"));
        //Loop from 1 to 100
        for (int i = 1; i <= 100; i++) {
            //If number is odd, write to file  
            if (i % 2 == 1) {
                writer2.print(i + ",");
            }
        }
        writer2.close();
        //Read from file
        FileInputStream fileStream2 = new FileInputStream("numbers.dat");
        DataInputStream in2 = new DataInputStream(fileStream2);
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(in2));
        //Print line
        System.out.println(reader2.readLine());
        reader.close();
    }
}