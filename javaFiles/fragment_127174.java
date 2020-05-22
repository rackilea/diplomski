// Create the process
Process process = new ProcessBuilder("neato", "-Tplain").start();

// Write to process's stdin
OutputStream osToProcess = process.getOutputStream();
PrintWriter pwToProcess = new PrintWriter(osToProcess);
pwToProcess.write("graph G { node1 -- node2; }"); // for example
pwToProcess.close();

// Read from process's stdout
InputStream isFromProcess = process.getInputStream();
BufferedReader brFromProcess = new BufferedReader(isFromProcess);
// do whatever you want with the reader, then...
brFromProcess.close();

// optionally...
process.waitFor();