Scanner sc = new Scanner(System.in); 
while (sc.hasNextLine()) {
    String line = sc.nextLine();
    Scanner lineScanner = new Scanner(line);
    //.... parse line...
    lineScanner.close();
}
sc.close();