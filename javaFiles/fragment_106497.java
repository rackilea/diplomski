public static void deleteLine() throws IOException{
    File mainFile = new File("H:\\EcD\\data.txt");
    File tempFile = new File("H:\\EcD\\tempFile");
    Scanner input = new Scanner(mainFile);
    String lineNumberToDelete = "4";
    while(input.hasNextLine()){
        String line = input.nextLine();
        if(!line.startsWith(lineNumberToDelete))
            System.out.println(line);
    }
    input.close();

}