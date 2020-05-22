while (data != -1) {
  data = reader.read();  // <<- here
  char current = (char) data;
  result += current;
  data = reader.read(); // <<- and here
}