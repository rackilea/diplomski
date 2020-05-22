String previousLine = null;
while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    if(previousLine != null && line.contains("Importing") && !previousLine.contains("Importing")) { 
        System.out.println(previousLine);
    }
    previousLine = line;
}