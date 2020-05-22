public class DataSheetTable extends JPanel {

public DataSheetTable(final FormContainer formContainer) {
........
 controlPanel = createControlPanel();
 add(controlPanel, BorderLayout.NORTH);


routingTable = new JTable(routingModel);
ListSelectionListener listener = new ListSelectionListener() {...};
routingTable.getSelectionModel().addListSelectionListener(listener);
              routingTable.getColumnModel().getSelectionModel().addListSelectionListener(listener);

.........
}

}