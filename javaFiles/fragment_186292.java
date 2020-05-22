import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;

public class TableCreate extends JFrame
{
    JPanel mainPanel;
    TableCreate() throws IOException
    {

        mainPanel=new JPanel(new BorderLayout());
        String InputFile1 = "TableCreate.java";
        BufferedReader breader1 = new BufferedReader(new FileReader(InputFile1));
        String line1 = "";
        line1 = breader1.readLine();

        DefaultTableModel model1 = new DefaultTableModel();
        model1.addColumn("line");

        while((line1=breader1.readLine()) != null)
         {
             System.out.println(line1);
             model1.addRow(new Object[]{line1});
         }
         breader1.close();

        JTable tab=new JTable(model1);

        tab.setPreferredScrollableViewportSize(new Dimension(300, 200));
        tab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnAdjuster tca = new TableColumnAdjuster(tab);
        tca.adjustColumns();

        JScrollPane js = new JScrollPane(tab);
        add(js);
    }

    public static void main(String[] args) throws IOException
    {
        TableCreate tc=new TableCreate();
        tc.pack();
        tc.setVisible(true);
        tc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}