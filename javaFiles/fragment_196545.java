String currentString = "mes:";
String changedString = "ins:";
try {
    BufferedReader reader = new BufferedReader(new FileReader(strFilePath));

    StringBuffer newContents = new StringBuffer();
    String currentLineIn = null;
    while ((currentLineIn = reader.readLine()) != null) {
        String trimmedLine = currentLineIn.trim();
        if (trimmedLine.contains(currentString)) {
            newContents.append(trimmedLine.replace(currentString, changedString));
        }
        else {
            newContents.append(trimmedLine);
        }
        newContents.append(System.getProperty("line.separator"));
    }

    reader.close();

    BufferedWriter writer = new BufferedWriter(new FileWriter(strFilePath));
    writer.write(newContents.toString());
    writer.close();

} catch (IOException e) {
    // TODO handle it
}