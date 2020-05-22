public class MyCellRenderer extends DefaultTableCellRenderer {
    @override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int rowIndex, int vColIndex) {
        SimpleTableModel mymodel = (SimpleTableModel) jxtableListar.getModel(); 
        ModelProtocolo actualModel= (ModelProtocolo ) mymodel.getProtocolo(rowIndex) ;

        JLabel label = (JLabel) super.getTableCellRendererComponent(/* pass in all params */);
        label.setText(/*whatever the text should be*/);
        label.setBackground(/*whatever the color should be*/);
        return label;
    }
}