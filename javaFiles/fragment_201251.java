BufferedWriter log;

Writer openForFile(String fileName) {
  if (fileName != null)
    return new PrintWriter(fileName);
  else
    return new OutputStreamWriter(System.out);
}

log = new BufferedWriter(openForFile(null)); //stdout
log = new BufferedWriter(openForFile("mylog.log")); // using a file