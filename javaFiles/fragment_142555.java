File file = new File("abhishek.txt");
Scanner scanner = new Scanner(file).useDelimiter("\n");
String line = scanner.next();
String newLine = line.substring(0, 5) + "Abhishek" + line.substring(5);
FileWriter writer = new FileWriter(file);
writer.write(newLine);
writer.close();