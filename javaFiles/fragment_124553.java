public class MyNoteUI extends javax.swing.JFrame {

    JFileChooser fc;

    /**
     * Creates new form MyNoteUI
     */
    public MyNoteUI() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new PopupMenuExample());
        setTitle("My NoteUI");

        initComponents();
    }