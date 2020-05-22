Component[] components = painelMain.getComponents();
List<List<String> list = new ArrayList<>();
List<String> line;

int i = 0, numCols = 3;
for (Component component : components) {
    if (i % numCols == 0) {
        line = new ArrayList<>();
        list.add(line);
    }
    String content = "";
    if (component instanceof JTextField) {
        content = ((JTextField) component).getText();            
    } else if (component instanceof JComboBox) {
        content = ((JComboBox<String>) component).getSelectedItem();
    }

    if (!content.isEmpty()) {
        line.add(content);
    }
    i = (i + 1) % 3;
}