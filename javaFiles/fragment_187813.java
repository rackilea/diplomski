import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**  Typical output:
[JTree, colors, violet]
User cancelled
[JTree, food, bananas]
Press any key to continue . . .
*/
class ConfirmDialog extends JDialog {

    public static final int OK_OPTION = 0;
    public static final int CANCEL_OPTION = 1;

    private int result = -1;

    JPanel content;

    public ConfirmDialog(Frame parent) {
        super(parent,true);

        JPanel gui = new JPanel(new BorderLayout(3,3));
        gui.setBorder(new EmptyBorder(5,5,5,5));
        content = new JPanel(new BorderLayout());
        gui.add(content, BorderLayout.CENTER);
        JPanel buttons = new JPanel(new FlowLayout(4));
        gui.add(buttons, BorderLayout.SOUTH);

        JButton ok = new JButton("OK");
        buttons.add(ok);
        ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                result = OK_OPTION;
                setVisible(false);
            }
        });

        JButton cancel = new JButton("Cancel");
        buttons.add(cancel);
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                result = CANCEL_OPTION;
                setVisible(false);
            }
        });

        setContentPane(gui);
    }

    public int showConfirmDialog(JComponent child, String title) {
        setTitle(title);
        content.removeAll();
        content.add(child, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getParent());

        setVisible(true);

        return result;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame f = new JFrame("Test ConfirmDialog");
                final ConfirmDialog dialog = new ConfirmDialog(f);
                final JTree tree = new JTree();
                tree.setVisibleRowCount(5);
                final JScrollPane treeScroll = new JScrollPane(tree);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JButton b = new JButton("Choose Tree Item");
                b.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae) {
                        int result = dialog.showConfirmDialog(
                            treeScroll, "Choose an item");
                        if (result==ConfirmDialog.OK_OPTION) {
                            System.out.println(tree.getSelectionPath());
                        } else {
                            System.out.println("User cancelled");
                        }
                    }
                });
                JPanel p = new JPanel(new BorderLayout());
                p.add(b);
                p.setBorder(new EmptyBorder(50,50,50,50));
                f.setContentPane(p);
                f.pack();
                f.setLocationByPlatform(true);
                f.setVisible(true);
            }
        });
    }
}