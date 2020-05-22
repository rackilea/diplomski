String inputLine = null;

while (...) {
    ...
    inputLine = in.readLine(); //I found ~9000 ns delay in this line.
    save.write(inputLine);
    ...
}