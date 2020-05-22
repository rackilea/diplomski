private static void generateCsvFile(String sFileName) {
    try {
        FileWriter writer = new FileWriter(sFileName);

        writer.append("DisplayName");
        writer.append(',');
        writer.append("Age");
        writer.append('\n');

        writer.append("YOUR NAME");
        writer.append(',');
        writer.append("100");
        writer.append('\n');

        // generate whatever data you want

        writer.flush();
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}