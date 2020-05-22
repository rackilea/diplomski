import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class PopupTesting extends javax.swing.JFrame {

    public PopupTesting() {
        initComponents();
        jTable.setComponentPopupMenu(getPopup());
    }

    volatile int lastMouse = 1;

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableMousePressed(evt);
            }
        });

        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        pack();
    }

    private void jTableMousePressed(java.awt.event.MouseEvent evt) {                                    
        lastMouse = evt.getButton();
        if (lastMouse == 3) lastMouse--;
        lastMouse = InputEvent.getMaskForButton(lastMouse);
    }                                 


    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PopupTesting.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new PopupTesting().setVisible(true);
        });
    }

    private JPopupMenu getPopup() {
        JPopupMenu popup = new JPopupMenu();

        JMenuItem m = new JMenuItem("Regular Menu Item");
        m.addActionListener((ActionEvent e) -> {
            System.out.println("I'm a menu Item.");
        });
        popup.add(m);
        PopupTesting frame = this;
        popup.addAncestorListener( new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                Point mousePoint = MouseInfo.getPointerInfo().getLocation();
                mousePoint = SwingUtilities.convertPoint(frame, parseInt(mousePoint.getX() - getX()), parseInt(mousePoint.getY() - getY()), jTable);
                jTable.setRowSelectionInterval(jTable.rowAtPoint(mousePoint), jTable.rowAtPoint(mousePoint));
            }
            @Override public void ancestorRemoved(AncestorEvent event) {
                try {
                    Robot bot = new Robot();
                    bot.mousePress(lastMouse);
                    bot.mouseRelease(lastMouse);
                } catch (AWTException ex) {
                    Logger.getLogger(PopupTesting.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            @Override public void ancestorMoved(AncestorEvent event) {}
        });
        return popup;
    }


    private int parseInt(Double val) {
        return val.intValue();
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;               
}