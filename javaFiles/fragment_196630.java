import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

class JScrollPaneToTopAction implements ActionListener, Runnable {

    JScrollPane scrollPane;

    public JScrollPaneToTopAction(JScrollPane scrollPane) {
        if (scrollPane == null) {
            throw new IllegalArgumentException("JScrollPaneToTopAction: null     JScrollPane");
        }
        this.scrollPane = scrollPane;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        new Thread(this).start();
    }

    @Override
    public void run() {
        JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
        int i = verticalBar.getMinimum();
        while (i < verticalBar.getMaximum()) {
            verticalBar.setValue(verticalBar.getMinimum() + i);
            i += 50;
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    scrollPane.getParent().invalidate();
                    scrollPane.repaint();
                    scrollPane.invalidate();
                }
            });
            System.out.println("changing " + i);
        }
    }
}

public class Draft20 {

    public static void main(String args[]) {
        JFrame frame = new JFrame("Tabbed Pane Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea tr = new JTextArea();

        JLabel label = new JLabel("Label");
        label.setPreferredSize(new Dimension(1000, 1000));
        JScrollPane jScrollPane = new JScrollPane(label);

        JButton bn = new JButton("Move");

        bn.addActionListener(new JScrollPaneToTopAction(jScrollPane));

        frame.add(bn, BorderLayout.SOUTH);
        frame.add(jScrollPane, BorderLayout.CENTER);
        frame.setSize(400, 150);
        frame.setVisible(true);
    }
}