int count = 0;

for (int i=0; i<countLines; i++) {
  ...
  // in place of: words[i] = read;
  words[count++] = read;
  ...
}