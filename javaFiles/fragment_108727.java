InputStream is = p.getInputStream();
// This simple reads the contents from the InputStream and discards it
// You could change it to actually dump the output if wanted ;)
while (is.read() != -1);

int exitValue = p.waitFor();