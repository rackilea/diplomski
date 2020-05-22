File file = new File("Student.txt");

try {
    Scanner scanner = new Scanner(file);

    //now read the file line by line...
    int lineNum = 0;
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        lineNum++;
        if(<some condition is met for the line>) { 
            System.out.println("ho hum, i found it on line " +lineNum);
        }
    }
} catch(FileNotFoundException e) { 
    //handle this
}