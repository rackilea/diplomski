boolean htmlFound = false;                        // Have we found an open html tag?
StringBuilder string = new StringBuilder();       // Back to your code...
String line;
while ((line = reader.readLine()) != null) {
  if (!htmlFound) {                               // Have we found it yet?
    if (line.toLowerCase().startsWith("<html")) { // Check if this line opens a html tag...
      htmlFound = true;                           // yes? Excellent!
    } else {
      continue;                                   // Skip over this line...
    }
  }
  System.out.println("This is each line: " + line);
  string.append(line + "\n");
}