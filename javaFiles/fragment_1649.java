import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class LazyCreation extends JPanel {
    private static final int PREF_W = 400;
    private static final int PREF_H = PREF_W;
    private Output output = new Output();
    private JDialog outputDialog = null;

    public LazyCreation() {
        add(new JButton(new DisplayOutputAction("Display Output")));
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class DisplayOutputAction extends AbstractAction {
        public DisplayOutputAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // lazily create dialog here
            if (outputDialog == null) {
                Window currentWin = SwingUtilities.getWindowAncestor(LazyCreation.this);
                outputDialog = new JDialog(currentWin, "Output Dialog", ModalityType.MODELESS);
                outputDialog.add(output);
                outputDialog.pack();
                outputDialog.setLocationRelativeTo(currentWin);
            }
            outputDialog.setVisible(true);

        }
    }

    private static void createAndShowGui() {
        LazyCreation mainPanel = new LazyCreation();

        JFrame frame = new JFrame("LazyCreation");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}


class Output extends JPanel {
    private JLabel label = new JLabel("Output", SwingConstants.CENTER);

    public Output() {
        label.setFont(label.getFont().deriveFont(Font.BOLD, 36));
        add(label);
    }
}