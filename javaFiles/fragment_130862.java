public class PetShopOverview extends JScrollPane {
public PetShopOverview(ArrayList<PetShop> petshopsSum) {
    Object[] columnNames = { "Name", "Opening Time" };
    Object[][] rowData = new Object[petshopsSum.size()][columnNames.length];
    DefaultTableModel listTableModel;

    int size = petshopsSum.size();

    for (int i = 0; i < size; i++) {
        rowData[i][0] = petshopsSum.get(i).getName();
        rowData[i][1] = petshopsSum.get(i).getOpeningTime();
    }

    listTableModel = new DefaultTableModel(rowData, columnNames);

    // -------------------------JTABLE AND JFRAME--------------------------
    JTable listTable;
    listTable = new JTable(listTableModel);
    this.setViewportView(listTable);
}}