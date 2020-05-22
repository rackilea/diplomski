public static void main(String[] args) {
  Scanner input=null;
  ArrayList<EmployeeFX> employeeList=new ArrayList<EmployeeFX>();
  try {
    FileReader Info=new FileReader("P01_DATA.txt");
    input=new Scanner(Info).useDelimiter("\\s+");   //Single white space regex is enough.
  }
  catch(FileNotFoundException noFile) {
    System.out.println("Can't open file");
    System.exit(1);
  }

  input.nextLine();   // Ignore the first line
  input.nextLine();   // Ignore the second line

  try {
    while(input.hasNext()) {    //hasNext() will check for the next available token
      employeeList.add(new EmployeeFX(input.nextInt(),input.next(),input.next(), input.nextBoolean(), input.nextInt()));
    }  // Additional newLine() reading is not required here.
  }
  catch(NoSuchElementException element) {
    System.err.println("Wrong type of file");
    System.exit(1);
  }
  catch(IllegalStateException state) {
    System.err.println("Couldn't read from file");
    System.exit(1);
  }
  if(input!=null) {
    input.close();
  }
}