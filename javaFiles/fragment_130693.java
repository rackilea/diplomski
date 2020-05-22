String[] headers = null;
String firstFile = "/path/to/firstFile.dat";
Scanner scanner = new Scanner(new File(firstFile));

if (scanner.hasNextLine())
    headers[] = scanner.nextLine().split(",");

scanner.close();

Iterator<File> iterFiles = listOfFilesToBeMerged.iterator();
BufferedWriter writer = new BufferedWriter(new FileWriter(firstFile, true));

while (iterFiles.hasNext()) {
  File nextFile = iterFiles.next();
  BufferedReader reader = new BufferedReader(new FileReader(nextFile));

  String line = null;
  String[] firstLine = null;
  if ((line = reader.readLine()) != null)
    firstLine = line.split(",");

  if (!Arrays.equals (headers, firstLine))
    throw new FileMergeException("Header mis-match between CSV files: '" +
              firstFile + "' and '" + nextFile.getAbsolutePath());

  while ((line = reader.readLine()) != null) {
    writer.write(line);
    writer.newLine();
  }

  reader.close();
}
writer.close();