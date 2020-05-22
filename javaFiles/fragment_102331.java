HashSet<String> keyWords = new HashSet<String>(
        Arrays.asList(new String[] {"void", "main()"}));
HashSet<String> dataTypes = new HashSet<String>(
        Arrays.asList(new String[] {"int", "float"}));

String newLine = System.getProperty("line.separator");
while ((currentLine = readFile.readLine()) != null) {
    String[] tokens= currentLine.split(" ");
    for (String token : tokens) {
        if (keyWords.contains(token)) {
            jTextArea1.append(token + newLine);
        } else if (dataTypes.contains(token)) {
            jTextArea2.append(token + newLine);
        }
    }
 }