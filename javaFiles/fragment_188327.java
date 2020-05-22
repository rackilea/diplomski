public class CellBox {
    private final JTextArea cell;

    public CellBox() {
        cell = new JTextArea(DIM_OF_CELLS, DIM_OF_CELLS));
        cell.setBorder(...);
        cell.setEditable(false);
        cell.addMouseListener(new MouseAdaptor() {
            public void mouseClicked(MouseEvent ev) {
                String text = JOptionPane.showInputDialog("Set text for date: ");
                cell.setText(text);      
            }
        });
    }
}