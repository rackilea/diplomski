try {
    FileWriter writer = new FileWriter(data_file, true);
    writer.write(str);
} catch(IOException e) {
    // oh no!
} finally {
    writer.close();
}