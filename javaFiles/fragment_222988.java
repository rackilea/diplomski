String targetText = "... the text to search";
String replacement = "The new text";
PrintWriter out = mkPrintWriter(/*...*/);

while (in.hasNextLine()) {
  String line = in.nextLine();
  if (line.equals(targetText)) {
    out.println(replacement);
  } else {
    out.println(line);
  }
}