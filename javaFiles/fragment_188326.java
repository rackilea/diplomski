private JTextArea makeCell(final int id) {
    JTextArea cell = new JTextArea(DIM_OF_CELLS, DIM_OF_CELLS));
    cell.setBorder(...);
    cell.setEditable(false);
    cell.addMouseListener(new MouseAdaptor() {
        public void mouseClicked(MouseEvent ev) {
            String text = JOptionPane.showInputDialog("Set text for date: ");
            allCells[id].get.setText(text);      
        }
    });
    return cell;
}