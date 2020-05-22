File file = new File("member.txt");
    FileWriter writer = null;
    try {
        writer = new FileWriter(file);
        writer.write("test");
    } catch (IOException e) {
        e.printStackTrace(); // I'd rather declare method with throws IOException and omit this catch.
    } finally {
        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
    }
    System.out.printf("File is located at %s%n", file.getAbsolutePath());