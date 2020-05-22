public static void ReadAndProcessPrint(File fileToRead) throws FileNotFoundException {
    java.util.Scanner scanner = new Scanner(fileToRead);
    while(scanner.hasNextLine()){
        String line = scanner.nextLine();
        if(line.startsWith("PRINT")){
            String restOfLine = line.substring(5);
            System.out.println(restOfLine);
        }else{
            //do other things
        }
    }
}