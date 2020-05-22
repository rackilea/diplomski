import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TestTable extends javax.swing.JFrame
{
    private JButton jButton1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private CustomRenderer renderer;

    public TestTable()
    {
        initComponents();
    }

    private void initComponents(){

        ///////////////////////////////////////////////
        //Initializing components
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        String data[][] = { {"A","B","C"},
                {"R","S","T"},
                {"U","V","W"}
        };
        String col[] = {"X","Y","Z"};
        jTable1 = new JTable(new DefaultTableModel(data, col));
        //Setup Renderer
        renderer = new CustomRenderer();
        //Add Renderer to table
        jTable1.getColumnModel().getColumn(0).setCellRenderer(renderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(renderer);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(renderer);

        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("jButton1");

        ///////////////////////////////////////////////
        //positioning button and table
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375,     javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(160, 160, 160))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117,     javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jButton1)
                        .addContainerGap(102, Short.MAX_VALUE))
        );

        ///////////////////////////////////////////////
        //create event callback for the button
        jButton1.setText("Change data & color");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ///////////////////////////////////////////////
        pack();
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {



        DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
        //change the data in the table
        String data[][] = { {"a","b","c"},
                {"r","s","t"},
                {"u","v","w"}  };
        String col[] = {"x","y","z"};
        model.setDataVector(data, col);

        // Necessary to re-add listener (because we're creating new columns) 
        jTable1.getColumnModel().getColumn(0).setCellRenderer(renderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(renderer);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(renderer);

        //change the header in the table
        jTable1.getTableHeader().setBackground(Color.red);


        // IS IT POSSIBLE TO INSERT CODE HERE, WITHOUT REINITIALIZING jTable1,
        // SO THAT CLICKING THE BUTTON WILL TURN THE MIDDLE ROW GREEN?
        renderer.colorModel.put(1, Color.green); //Yes

        //change button text
        jButton1.setText("Changed");
    }


    public static void main(String[] args) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestTable().setVisible(true);
            }
        });

    }

    //Custom Renderer - does the default rendering except if told the row should be a different color
    public static class CustomRenderer extends DefaultTableCellRenderer{

        //Stores what color you want for rows
        public HashMap<Integer, Color> colorModel = new HashMap<Integer, Color>();

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {
            //Default Rendering
            Component result = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            //Change color of background (If necessary)
            if(colorModel.get(row) != null){
                setBackground(colorModel.get(row));
            } else if(!isSelected){
                setBackground(null);
            }
            return result;
        }

    }
}