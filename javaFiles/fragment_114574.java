//read file name from stdio
File inFile = new File(fileName);
int i = 0;
while(!inFile.exists() && i++ < 2 ){
        //read file name from System.in;
        inFile = new File(fileName);
}
Scanner in = new Scanner(new File(fileName));