private static void writeListToFile(String filePath, ArrayList<String> list, boolean... appendToFile) {
    boolean appendFile = false;
    if (appendToFile.length > 0) { appendFile = appendToFile[0]; }

    try {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, appendFile))) {
            for (int i = 0; i < list.size(); i++) {
                bw.append(list.get(i) + System.lineSeparator());
            }
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}