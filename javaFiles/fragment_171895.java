while (line = readLine()) {
    String cmdString = null;
    if (line.beginsWith("create" || line.beginsWith("alter") ...) {
       String previousLine = line;
       while (line = readLine()) {
          if (line.equals("/") && previousLine.endsWith(";")) {
            executeSQL(cmdString);
            break;
          }
          previousLine = line;
          cmdString = cmdString + line;
       }
    }
    if (line.beginsWith("insert" || line.beginsWith("update") ...) {
       String previousLine = line;
       while (line = readLine()) {
          if (line.equals("\n") && previousLine.endsWith(";")) {
            executeSQL(cmdString);
            break;
          }
          previousLine = line;
          cmdString = cmdString + line;
       }
    }
    // skip others
}