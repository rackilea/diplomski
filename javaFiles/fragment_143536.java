public class ButtonColumnRenderer extends JComponent implements TableCellRenderer {

    private final JButton button;

    public ButtonColumnRenderer(){
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        button = new JButton();
        add(Box.createHorizontalGlue());
        add(button);
        add(Box.createHorizontalGlue());
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        button.setText(String.valueOf(value));
        return this;
    }
}