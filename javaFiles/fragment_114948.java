public class TabData extends JPanel {

    JComboBox someData;

    ...

    // Get rid of DataListener class and add this public method instead:
    public void addActionListenerToComboBox(ActionListener listener) {
        someData.addActionListener(listener);
    }
}