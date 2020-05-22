File file = new File("C:\\testing1.txt");
Scanner scanner = new Scanner(file);

SIZE = 0;

// count the numbers
while(scanner.hasNext()) {
  SIZE++;
  scanner.next()
}

numbers = new int[SIZE];

// reopen the scanner
scanner.close();
scanner = new Scanner(file);