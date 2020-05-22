Scanner sc = new Scanner(System.in);
Scanner input = null;
boolean isFile = false;

while (isFile == false){    

    System.out.print("Input file name? ");
    String fileName = sc.next();
    File inputFile = new File(fileName);

    if (inputFile.exists()){
        input = new Scanner(inputFile);
        isFile = true;
    }            
}