public class MyJFrame extends javax.swing.JFrame {

    public MyJFrame() {
        JButton btn = new JButton("open file");
        add(btn);
        btn.addActionListener(e -> {
            selectFile();
        });
        pack();
        setVisible(true);
    }

    public void selectFile() {
        JFileChooser chooser = new JFileChooser();
        // optionally set chooser options ...
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            // read  and/or display the file somehow. ....
        } else {
            // user changed their mind
        }
    }
}