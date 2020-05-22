BufferedWriter out = new BufferedWriter(
    new OutputStreamWriter(
        new FileOutputStream("file.txt", true), // true to append
        StandardCharsets.UTF_8                  // Set encoding
    )
);