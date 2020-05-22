Scanner scanner = new Scanner(new File("/path/to/file.txt"));
while ( scanner.hasNextLine() )
{
  String line = scanner.nextLine()
  ... // parsing code in here
}