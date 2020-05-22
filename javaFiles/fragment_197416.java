public class SettingsView extends JPanel {

    private JComboBox<String> comboBox;
    private static final String[] strings = {"Hello", "World"};

    public SettingsView(ActionListener listener) {
        comboBox = new JComboBox<>(strings);
        comboBox.addActionListener(listener);
    }

    public void simComboChange(int selected) {
        System.out.println("Simulating combo change");
        comboBox.setSelectedIndex(selected);
        comboBox.actionPerformed(new ActionEvent(comboBox, 0, "SimAction"));
    }
}