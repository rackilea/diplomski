// create a scanner of the file
Scanner scan = new Scanner(new File("filename"));

// read the first token as an int to know array length
int length = scan.nextInt();

String [] col1 = new String[length];
int [] col2 = new int[length];

// assuming valid data, loop through each row
for(int i = 0; i < length; i++){
  col1[i] = scan.next();
  col2[i] = scan.nextInt();
}