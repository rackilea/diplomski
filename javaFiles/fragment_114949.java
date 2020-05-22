public class Tabs extends JTabbedPane {

    public Tabs() {
        go();
    }

    public void go() {
        TabData data = new TabData();           
        data.addActionListenerToComboBox(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox)e.getSource();
                boolean enableSecondTab = comboBox.getSelectedIndex() > -1;
                setEnabledAt(1, enableSecondTab);
            }

        });
        add("  Data  ", data);
        TabCalculation calculation = new TabCalculation();
        add("Calculation", calculation);
        setEnabledAt(1, false);
    }
}