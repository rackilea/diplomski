public class myTables extends javax.swing.JPanel {

int tableID = 0;

public myTables() {
    initComponents();
}

public void setTableID(int i){
    tableID = i;
}
public int getTableID(){
    return tableID;
}
@SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    table = new javax.swing.JTable();

    setLayout(new java.awt.CardLayout());

    table.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    jScrollPane1.setViewportView(table);

    add(jScrollPane1, "card2");
}// </editor-fold>                        


// Variables declaration - do not modify                     
private javax.swing.JScrollPane jScrollPane1;
public javax.swing.JTable table;
// End of variables declaration