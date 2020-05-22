// Right way (Java 6 and earlier)
Socket sock = new Socket(...);
try {
  sock.connect();
  // do stuff including a read that might time out
} finally {
  sock.close();
}

// Right way (Java 7 and later)
try (Socket sock = new Socket(...)) {
  sock.connect();
  // do stuff including a read that might time out
}