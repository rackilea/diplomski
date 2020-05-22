import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class Main {

    static JScrollPane scrollPane;

    public static void main(String[] args) {

        JFrame f = new JFrame();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setBounds(0, 0, dim.width, dim.height);

        StandartPanel p = new StandartPanel();

        f.add(p);

        JToolBar tb = new JToolBar();

        JButton button = new JButton("Button");
        button.setFocusable(false);

        tb.add(button);
        //tb.setFocusable(false);

        f.add(tb, BorderLayout.NORTH);
        f.setVisible(true);
    }

    static class StandartPanel extends JPanel {

        public StandartPanel() {

            for (int i = 0; i < 10; i++) {
                this.add(new JLabel("Jlabel number: " + i));
            }

            this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                    KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "forward");
            this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                    KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "forward");
            this.getActionMap().put("forward", new AbstractAction() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("pressed");
                }
            });
        }

    }

}