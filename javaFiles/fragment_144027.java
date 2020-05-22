import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;

public class Screen {

    private JFrame frame;
    public JFileChooser choicer = new JFileChooser();
    public Font f = new Font("Candara", Font.PLAIN, 16);
    public TableMethods tm = new TableMethods();
    String dir;
    JTable Table;
    String[] columns;
    String[][] data;
    JScrollPane jsp;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Screen window = new Screen();
                    //window.frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Screen() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Spreadr");
        frame.setBounds(100, 100, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu FileMenu = new JMenu("File");
        FileMenu.setFont(f);
        menuBar.add(FileMenu);

        JMenuItem New_Doc = new JMenuItem("New Document");
        New_Doc.setFont(f);
        New_Doc.addActionListener(e -> {
            choicer.setCurrentDirectory(new java.io.File("."));
            choicer.setDialogTitle("New Document");
            choicer.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            choicer.setAcceptAllFileFilterUsed(false);

            if (choicer.showOpenDialog(new JPanel()) == JFileChooser.APPROVE_OPTION) {
                dir = String.valueOf(choicer.getCurrentDirectory());
            }
        });
        FileMenu.add(New_Doc);

        JMenuItem Save_Doc = new JMenuItem("Save Document");
        Save_Doc.setFont(f);
        FileMenu.add(Save_Doc);

        JMenuItem Open_Doc = new JMenuItem("Open Document");
        Open_Doc.setFont(f);
        FileMenu.add(Open_Doc);

        JMenu EditMenu = new JMenu("Edit");
        EditMenu.setFont(f);
        menuBar.add(EditMenu);

        JMenuItem Copy = new JMenuItem("Copy");
        Copy.setFont(f);
        EditMenu.add(Copy);

        JMenuItem Cut = new JMenuItem("Cut");
        Cut.setFont(f);
        EditMenu.add(Cut);

        JMenuItem Paste = new JMenuItem("Paste");
        Paste.setFont(f);
        EditMenu.add(Paste);
        EditMenu.addSeparator();

        JMenuItem EditRows = new JMenuItem("Edit Rows...");
        EditRows.setFont(f);
        JMenuItem EditColumns = new JMenuItem("Edit Columns...");
        EditColumns.setFont(f);

        EditMenu.add(EditColumns);
        EditMenu.add(EditRows);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        Table = new JTable();
        Table = tm.newTable(Table);
        jsp = new JScrollPane(Table);
        frame.add(jsp);
        frame.pack();
        frame.setVisible(true);
    }

    class TableMethods {
        public JTable newTable(JTable table) {
            int i = 1;
            columns = new String[10];
            while (i <= 10) {
                columns[i++ - 1] = String.valueOf(i); //Increment i
            }
            data = new String[10][10]; //Initialize data.
            i = 0;
            int j = 0;
            while (i < 10) {
                j=0;  //Set j to 0.
                while (j < 2) {
                    data[i][j] = String.valueOf(i + j);
                    j++;
                }
                i++;
            }
            table = new JTable(data, columns);
            table.setFillsViewportHeight(false);
            table.setDragEnabled(false);
            frame.getContentPane().add(table);
            return table;
        }
    }
}