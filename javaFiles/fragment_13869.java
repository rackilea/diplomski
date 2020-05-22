import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class McveExample extends JPanel {
    private static final String[] DATA = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final int PREF_W = 400;
    private static final int PREF_H = 250;
    private JList<String> list = new JList<>(DATA);
    private JButton myButton = new JButton();

    public McveExample() {

        myButton.setVisible(false);  // **** make button invisible

        list.setVisibleRowCount(4);
        list.addListSelectionListener(new ListListener()); // listener that does the dirty work

        JScrollPane scrollPane = new JScrollPane(list);

        // add a JButton that resets myButton back to being invisible
        add(new JButton(new ResetAction("Reset", KeyEvent.VK_R)));
        add(scrollPane);
        add(myButton);
    }

    // make sure things are big enough
    @Override
    public Dimension getPreferredSize() {
        Dimension superSz = super.getPreferredSize();
        if (isPreferredSizeSet()) {
            return superSz;
        }
        int prefW = Math.max(superSz.width, PREF_W);
        int prefH = Math.max(superSz.height, PREF_H);
        return new Dimension(prefW, prefH);
    }

    private class ResetAction extends AbstractAction {
        public ResetAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            list.clearSelection();
            myButton.setVisible(false);
            McveExample.this.revalidate();
            McveExample.this.repaint();
        }
    }

    private class ListListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                JList<String> lst = (JList<String>) e.getSource();
                String selection = lst.getSelectedValue();
                if (selection != null) {
                    myButton.setText(selection);
                    myButton.setVisible(true);
                    McveExample.this.revalidate();
                    McveExample.this.repaint();
                }
            }
        }
    }

    private static void createAndShowGui() {
        McveExample mainPanel = new McveExample();

        JFrame frame = new JFrame("McveExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}