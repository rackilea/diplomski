BufferedReader is;  // reader for output of process
String line;

// getInputStream gives an Input stream connected to
// the process standard output. Just use it to make
// a BufferedReader to readLine() what the program writes out.
is = new BufferedReader(new InputStreamReader(p.getInputStream()));

while ((line = is.readLine()) != null)
  System.out.println(line);