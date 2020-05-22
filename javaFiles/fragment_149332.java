public class wampusGUI extends javax.swing.JFrame {

    /**
     * Creates new form wampusGUI
     */
    public wampusGUI() {
        initComponents();
    }

    public void textArea1(String text) {
        System.out.print(text);
        displayTextArea.append(text); // this is not appending to textarea.
    }

           /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                wampusGUI w=new wampusGUI();
                w.setVisible(true);
                Game g = new Game(w);
                g.testing();
            }
        });
    }