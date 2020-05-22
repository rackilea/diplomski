Scanner scanner = new Scanner(firstFile);
int lineNum = 0;
while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    lineNum++;
    Scanner scanner1 =new Scanner(secondFile);
    while (scanner1.hasNextLine()) {
        String line1 = scanner1.nextLine();
        if(line.contains(line1)) { 
            System.out.println("Ignore/Review line number: "+lineNum);      
        }
    }
}