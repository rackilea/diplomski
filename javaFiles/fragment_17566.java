public void getDataFromFile(File file, JTable table) {
    String[] colNames  = { "Your", "Column", "Names", "Go", "Here" };
    DefaultTableModel model = new DefaultTableModel(colNames, 0);

    try (BufferedReader br = new BufferedReader(new FileReader(file)) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split("\\s+");
            model.addRow(data);
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    table.setModel(model);
}