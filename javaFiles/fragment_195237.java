// generics version
private HashMap<String, String> testMessages = buildMap();

for (String v : testMessages.values()) {
  if (filename.startsWith(v) {
    // found a map value that starts the file name
  }
}

// alternative non-generics version
private HashMap testMessages; // assigned somewhere

for (Object v : testMessages.values()) {
  if (filename.startsWith((String) v) {
    // found a map value that starts the file name
  }
}