class InventoryOutput implements ActionListener {
    private final String REPOSITORY_FILE_PATH = "C:\\temp\\book-repo.txt";
    private final File REPOSITORY_FILE = new File(REPOSITORY_FILE_PATH);

    public void actionPerformed(ActionEvent event) {
        String inventoryString = "";

        String requestedISBN = txtISBN.getText().trim().toLowerCase();
        String requestedAuthor = txtAuthor.getText().trim();
        String requestedType = txtType.getText().trim();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(REPOSITORY_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                String lineLtrim = line.toLowerCase().replaceAll("^\\{", ""); //{
                String lineRtrim = lineLtrim.replaceAll("\\}$", ""); //}
                String[] data = lineRtrim.split(","); //ISBN, Author, Type, Stock
                if (data.length < 4) {
                    throw new IllegalArgumentException("bad datafile: All fields must be entered: " + line);
                }
                if (data[0].equals(requestedISBN)) {
                    inventoryString += txtISBN.getText() + " - Author: " + data[1] + " - Type: " + data[2] + " - Stock:" + data[3];
                    txtOutput.append(inventoryString + "\n");
                    return;
                }
            }
            reader.close();
            inventoryString += txtISBN.getText() + " -  Not Found";
            txtOutput.append(inventoryString + "\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}