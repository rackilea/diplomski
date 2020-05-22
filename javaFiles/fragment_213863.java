public static void main(String[] args) throws FileNotFoundException {
        //open file containing integers
        File file = new File("C:\\test_java\\readnumbers.txt"); 

        //instruct Scanner to read from file source
        Scanner scanner = new Scanner(file); 

        //create file object for output
        File outFile = new File("C:\\test_java\\incremented_numbers.txt");

        //print writer with source as file 
        PrintWriter writer = new PrintWriter(outFile); 

        //for each line in input file 
        while(scanner.hasNext()) {
            //get the integer in the line 
            int number = scanner.nextInt(); 
            number *= 10; 

            //write the updated integer in the output file
            writer.println(number);
        }

        //close both streams
        scanner.close();
        writer.close();
    }