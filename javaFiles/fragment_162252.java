public class MyListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component cell = null;

        if (value instanceof Domain) {
            Domain domain = (Domain)value;
            int status = domain.getStatus();
            String naziv = domain.getNaziv();

            cell = super.getListCellRendererComponent(list, 
                naziv, // note this...
                index, 
                isSelected, 
                cellHasFocus);

            if (status > 0) { // or whatever...
                cell.setBackground(STATUS_ON_COLOR);
            } else {
                cell.setBackground(STATUS_OFF_COLOR);
            }
        }
    }

    return cell;
}