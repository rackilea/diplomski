Scanner scanner = new Scanner(System.in);
System.out.println("Please input grades");

String line = scanner.nextLine();

while ( line.length() > 0 ) // quit when user enters no data
{
  String[] data = line.split("|"); // store the data in an array
  name = data[0];
  // use a for-loop to iterate from index 1 to data.length to see all the grades
  ...
  line = scanner.nextLine();
}