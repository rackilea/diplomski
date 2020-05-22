List<String> lines = myCSVReader.readAll();

// lets print the output of the first three lines
for (int i=0, i<3, i++) {
  String[] lineTokens = lines.get(i);
  System.out.println("line:" + (i+1) + "\tlength:" + lineTokens.length);
  // print each of the tokens
  for (String token : lineTokens) {
    System.out.println("\ttoken: " + token);
  }
}

// only process the file if lines two or three aren't empty
if (lineTokens.get(1).length > 0 || lineTokens.get(2).length > 0) {
  System.out.println("Process this file!");
  processFile(lineTokens);
}
else {
  System.out.println("Skipping...!");
}

// EXPECTED OUTPUT:
// line:1  length:0
// line:2  length:0
// line:3  length:3
//         token: The above lines are empty
//         token: 12345
//         token: foo
// Process this file!