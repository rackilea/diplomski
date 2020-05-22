// Efficient use of memory
  try (InputStream is = new FileInputStream(largeFileName);
       BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
      String line;
      while ((line = br.readLine()) != null) {
          // process one line
      }
  }

  // Inefficient use of memory
  try (InputStream is = new FileInputStream(largeFileName);
       BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
      StringBuilder sb = new StringBuilder();
      while ((line = br.readLine()) != null) {
          sb.append(line).append("\n");
      }
      String everything = sb.toString();
      // process the entire string
  }

  // Very inefficient use of memory
  try (InputStream is = new FileInputStream(largeFileName);
       BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
      String everything = "";
      while ((line = br.readLine()) != null) {
          everything += line + "\n";
      }
      // process the entire string
  }