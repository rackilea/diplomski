DefaultTableModel model = new DefaultTableModel();

try (BufferedReader br = new BufferedReader(new FileReader(file)) {

    String line = br.readLine();
    String[] colHeaders = line.split("\\s+");
    model.setColumnIdentifiers(colHeaders);

    while ((line = br.readLine()) != null) {
        String[] data = line.split("\\s+");
        model.addRow(data);
    }
}