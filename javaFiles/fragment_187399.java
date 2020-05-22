FileInputStream fileInputStream = new FileInputStream("C:/test.txt");
Scanner scanner = new Scanner(fileInputStream);
Scanner lineScanner;

String surname = "";
String name = "";

while (scanner.hasNextLine()) {
    String delimiterInFile = " ";
    String lineInFile = scanner.nextLine();

    lineScanner = new Scanner(lineInFile).useDelimiter(delimiterInFile);

    if(lineScanner.hasNext()){
        surname = lineScanner.next();
    }
    if(lineScanner.hasNext()){
        name = lineScanner.next();
    }

    System.out.println(String.format("%s %s", name, surname));
}