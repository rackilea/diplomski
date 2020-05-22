if (!key.isValid()) {
  continue;
}

if (key.isConnectable()) {
  connect(key);
} else if (key.isAcceptable()) {
  accept(key);
} else if (key.isReadable()) {
  read(key);
} else if (key.isWritable()) {
  write(key);
}