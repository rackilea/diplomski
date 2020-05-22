import javax.swing.*; 
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*; 
public class TestTable extends JFrame{

    public TestTable(){ 
        init(); 
    } 

    public final void init(){ 
        String[] columnNames = {"", "Gross Weight"}; 

        Object[][] data = {{"", new Integer(100)},}; 

        final JTable table = new JTable(data, columnNames); 
        // Add Renderer to first column only
        table.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer());
        table.setPreferredScrollableViewportSize(new Dimension(500, 70)); 
        table.setFillsViewportHeight(true); 

        JScrollPane scrollPane = new JScrollPane(table); 
        scrollPane.setPreferredSize(new Dimension(300, 200));
        add(scrollPane); 
    } 

    public static void main(String[] args) { 
        SwingUtilities.invokeLater(new Runnable() { 

            public void run() { 
                try { 
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); 
                } catch (Exception e) { 
                    e.printStackTrace(); 
                } 
                TestTable ex = new TestTable();
                ex.pack();
                ex.setVisible(true); 

            } 
        }); 
    } 

    //Custom Renderer - does the default rendering except if told the row should be a different color
    public static class CustomRenderer extends DefaultTableCellRenderer{

        public CustomRenderer(){
            super();
            //Customize the rendering however you want
            setBackground(UIManager.getColor("TableHeader.background"));
        }
    }

}