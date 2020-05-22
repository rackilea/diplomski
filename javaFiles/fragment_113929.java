public void writeRandomChunk(String fileName) {
    PrintWriter writer = null;
    try {
        File saveFile = new File(folderName + '/' + fileName);
        writer = new PrintWriter(
                             new BufferedWriter(
                             new FileWriter(saveFile)));

        Random r = new Random(System.currentTimeMillis());

        for (int i = 0; i < chunkSize; i++) {
            for (int j = 0; j < chunkSize; j++) {
                writer.print((char)(r.nextInt(26) + 'a'));
            }
            writer.println();
        }

    } catch (Exception e) {
        System.out.println("Error in WorldFile writeRandomFile:\n"
                           + e.getLocalizedMessage());
    } finally {
        if (writer != null)
            writer.close();
    }
}