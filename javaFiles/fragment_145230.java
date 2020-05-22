public static void parseFile(String s) throws FileNotFoundException {
    File file = new File("data.txt");

    Scanner scanner = new Scanner(file);
    int flag_found=0;
    while (scanner.hasNextLine()) {
        final String lineFromFile = scanner.nextLine();
        if (lineFromFile.contains(s)) {
            // a match!
            System.out.println(lineFromFile);
            flag_found = 1;//Input is found
        }
    }

    if(flag_found==0){// input is not found in the txt file so flag_found remains 0
      Writer();
    }       
}