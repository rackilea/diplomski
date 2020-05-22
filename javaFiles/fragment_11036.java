import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;


public class Tester {
    JFrame frane;
    JPanel mainP;
    JTable table;
    public void testIt() {
        frane=new JFrame("testing");
        populateGui();
        frane.setContentPane(mainP);
        frane.pack();
        frane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frane.setVisible(true);
    }
    private void populateGui() {
        mainP=new JPanel();
        String[] colName={"first col","second","3rd coll"};
        String[][] information={
                    {"DUCK","QUACK","MacDuck"}
                };
        table=new JTable(information, colName);
        table.removeColumn(table.getColumnModel().getColumn(2));
        System.out.println(table.
                getColumnModel().
                    getColumnCount()
        );
        System.out.println(table.
                getModel().
                    getColumnCount()
        );
        table=new JTable(table.getModel());  // yet all the data object that were present in data array () "information" are still there
        /*table.addColumn(
                table.getColumnModel().          there is no column 2 since it was removed from ColumRendere (ColumnModel)
                    getColumn(2));*/
        mainP.add(table);
    }
}