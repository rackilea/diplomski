public class ApplicationViewer extends JFrame {

public ApplicationViewer(ArrayList<PetShop> petshops) {
    viewer(petshops);
}

public void viewer(final ArrayList<PetShop> petshops) {

    PetShopOverview ov = new PetShopOverview(petshops);

    Object[] columnNames = { "Name", "Address", "Phone Number", "Website", "Opening Time" }; // declaring columns
                                                                                             // names
    Object[][] rowData = new Object[petshops.size()][columnNames.length]; // initializing rows.
    DefaultTableModel listTableModel;

    for (int i = 0; i < petshops.size(); i++) { // this for loop adds data from the arraylist to each coloumn.
        rowData[i][0] = petshops.get(i).getName();
        rowData[i][1] = petshops.get(i).getAddress();
        rowData[i][2] = petshops.get(i).getPhoneNumber();
        rowData[i][3] = petshops.get(i).getWebsite();
        rowData[i][4] = petshops.get(i).getOpeningTime();
    }

    listTableModel = new DefaultTableModel(rowData, columnNames);
    JPanel panelLB = new JPanel();
    JPanel panel = new JPanel();
    JPanel panelBT = new JPanel();
    JButton btnViewSum = new JButton("View Summary");
    JButton btnExp = new JButton("Export table data");

    // ---------------------JTABLE AND JFRAME (adding adding table, panels and buttons to the
    // jframe)--------------------------------------------------------

    JTable listTable;
    listTable = new JTable(listTableModel);

    listTable.setRowSelectionAllowed(true);
    JScrollPane scroll = new JScrollPane(listTable);
    scroll.setViewportView(listTable);
    JTabbedPane tab = new JTabbedPane();

    tab.addTab("Tab1", scroll);
    tab.addTab("Tab2", new PetShopOverview(petshops));
    JLabel lb = new JLabel("Welcome to Pet shop app");
    panelBT.add(lb);
    panelBT.add(btnExp);
    panelBT.add(btnViewSum);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.setSize(600, 400);
    this.add(panelBT);
    this.add(tab);
    this.getContentPane().add(panelBT, java.awt.BorderLayout.NORTH);
    this.getContentPane().add(tab, java.awt.BorderLayout.CENTER);
    this.setVisible(true);
}}