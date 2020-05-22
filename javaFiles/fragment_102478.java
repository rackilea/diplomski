ProcessBuilder pb = new ProcessBuilder(command);
pb.redirectErrorStream(true);
BufferedReader b1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
BufferedWriter w1 = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
String line = "";
String outp = "";
while ((line = b1.readLine()) != null) {
  if (line.equals("PLEASE INPUT THE VALUE:")) {
     // output to stream
     w1.write("42");
  }
  outp += line + "\n";
}

...