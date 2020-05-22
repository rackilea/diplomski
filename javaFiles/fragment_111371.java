public class TestFrame extends JFrame {
ImageIcon iconChecked = new ImageIcon(TestFrame.class.getResource("checked.png"));
ImageIcon iconUnchecked = new ImageIcon(TestFrame.class.getResource("unchecked.png"));
JList jList = new JList(new Object[]{"ABC", "123"});

public TestFrame() {
    this.add(jList);
    jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

jList.setCellRenderer(new ListCellRenderer() {
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        for (int i : list.getSelectedIndices()) {
            if (index == i) {
                JCheckBox checkBoxChecked = new JCheckBox(value.toString(), iconChecked);
                return checkBoxChecked;
            }
        }

        JCheckBox checkBoxUnchecked = new JCheckBox(value.toString(), iconUnchecked);
        return checkBoxUnchecked;
    }
});
}}