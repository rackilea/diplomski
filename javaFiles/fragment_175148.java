Process process = Runtime.getRuntime().exec(command);
OutputStream stdin = process.getOutputStream();
InputStream stdout = process.getInputStream();

// Start a background thread that writes input file into "stdin" stream
...

// Read the results from "stdout" stream
...