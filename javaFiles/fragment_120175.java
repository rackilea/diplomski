Scanner inFile = null;
...
try {
    inFile = new Scanner(file);
    while(inFile.hasNext()) {
    }    
}
catch (FileNotFoundException e) {
    System.out.println("FileNotFoundException");
}