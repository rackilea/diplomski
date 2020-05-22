import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public enum ShowTable  {

    INSTANCE;

    private JFrame f = new JFrame();
    private JTable jt = new JTable(new DefaultTableModel());
    private DefaultTableModel model = (DefaultTableModel) jt.getModel();

    private ShowTable() {
        jt.setBounds(30, 40, 200, 300);
        jt.setFocusable(false);
        jt.setRowSelectionAllowed(false);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(1300, 100);
    }

    public void showdata(int count, String host, String ip, String os_name, String os_arch,
            String os_version, String pro_detail, String Mac_add, float disk_size, float max_memory) {
        //System.out.println("Row  :"+count);
        Object data[] = {host, ip, os_name, os_arch, os_version, pro_detail, Mac_add, disk_size, max_memory};
        if (count == 0) {
            model.addColumn("HOSTNAME");
            model.addColumn("IP ADDRESS");
            model.addColumn("OS NAME");
            model.addColumn("OS ARCHITECTURE");
            model.addColumn("OS VERSION");
            model.addColumn("PROCESSOR DETAIL");
            model.addColumn("MAC ADDRESS");
            model.addColumn("HARD DISK");
            model.addColumn("RAM SIZE");
            model.addRow(data);
        } else {
            model.addRow(data);
        }
        f.setVisible(true);
    }
}