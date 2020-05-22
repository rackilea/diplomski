import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Save3 extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    public int PADDING = 10;

    public JMenuItem menuNew;
    public JMenuItem menuOpen;
    public JMenuItem menuSave;
    public JMenuItem menuExit;

    public JPanel container;

    public DefaultTableModel model;
    public JScrollPane scrollPane;
    public JTable table;

    public FileInputStream fis;
    public ObjectInputStream in;
    public FileOutputStream fos;
    public ObjectOutputStream out;
    public String filename;

    String[] columnNames = {"", "MotorBike", " Car"};
    Object[][] data = { {"Vehicle Summary", new Integer(100), new Integer(200)},  // Header 1: Green
    {"Axle Numbers", new Integer(100), new Integer(200)}, {"Axle Code", new Integer(100), new Integer(200)}, {"Axle Distances (cm)", new Integer(100), new Integer(200)}, {"Vehicle Speed (km/h)", new Integer(100), new Integer(200)}, {"Gross Weight", new Integer(100), new Integer(200)}, {"Axle Weight 1", new Integer(100), new Integer(200)}, {"Axle Weight 2", new Integer(100), new Integer(200)},};

    public Save3() {
        fis = null;
        in = null;
        fos = null;
        out = null;
        filename = "test.ref";
        initGUI();
    }

    public void initGUI() {
        setTitle("WIM Reference Data Comparison Tool");
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu Bar and Menu Items setup
        JMenuBar menuBar;
        JMenu menu;

        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        menuBar.add(menu);

        menuNew = new JMenuItem("New");
        menuOpen = new JMenuItem("Open");
        menuSave = new JMenuItem("Save");
        menuExit = new JMenuItem("Exit");

        menuNew.addActionListener(this);
        menuOpen.addActionListener(this);
        menuSave.addActionListener(this);
        menuExit.addActionListener(this);

        menu.add(menuNew);
        menu.add(menuOpen);
        menu.add(menuSave);
        menu.add(menuExit);
        setJMenuBar(menuBar);

        container = new JPanel(new BorderLayout());

        model = new DefaultTableModel(data, columnNames);
        table = new JTable();
        table.setModel(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(table);

        container.add(scrollPane, BorderLayout.CENTER);
        add(container);
    }

    public void setModel(DefaultTableModel writeModel) {
        table.setModel(writeModel);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicked item!");
        if (e.getSource() == menuNew) {
            System.out.println("New File");
        } else if (e.getSource() == menuSave) {
            System.out.println("Save!");
            try {
                fos = new FileOutputStream(filename);
                out = new ObjectOutputStream(fos);
                table.clearSelection();
                table.setModel(new DefaultTableModel());
                out.writeObject(model);
                table.setModel(model);
            } catch (IOException e3) {
                e3.printStackTrace();
            } finally {
                try {
                    out.close();
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        } else if (e.getSource() == menuOpen) {
            System.out.println("Open!");
            try {
                fis = new FileInputStream(filename);
                in = new ObjectInputStream(fis);
                DefaultTableModel modelRead = (DefaultTableModel) in.readObject();
                setModel(modelRead);
                System.out.println("data loaded");
                in.close();
                fis.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        } else if (e.getSource() == menuExit) {
            System.out.println("Exit!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Save3 ex = new Save3();
                ex.setVisible(true);
            }
        });
    }
}