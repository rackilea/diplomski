void populatedAcurap() {
    try (BufferedReader reader = new BufferedReader(new FileReader(Files.newInputStream(Aparts)))) {
        String temp2 = null;
        DefaultListModel model = new DefaultListModel();
        while((temp2 = reader.readLine()) != null) {
            model.addElement(temp2);
        }
        list.setModel(model);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}