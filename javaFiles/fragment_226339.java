import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class SwingExample extends JPanel {
    private JButton openDialogBtn = new JButton(new OpenDialogAction("Open Dialog"));
    private JDialog dialog;
    private DialogPanel dialogPanel = new DialogPanel();

    public SwingExample() {
        setPreferredSize(new Dimension(400, 400));
        add(openDialogBtn);
    }

    private class OpenDialogAction extends AbstractAction {
        public OpenDialogAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dialogPanel.setText("");
            if (dialog == null) {
                Window win = SwingUtilities.getWindowAncestor(SwingExample.this);
                dialog = new JDialog(win, "Dialog", ModalityType.MODELESS);
                dialog.add(dialogPanel);
                dialog.pack();
                dialog.setLocationRelativeTo(win);
            }
            new SwingWorker<Void, Integer> () {
                private final int maxI = 5;

                @Override
                protected Void doInBackground() throws Exception {
                    for (int i = 0; i < maxI; i++) {
                        publish(i);
                        Thread.sleep(1000);
                    }
                    return null;
                }

                protected void process(java.util.List<Integer> chunks) {
                    for (Integer chunk : chunks) {
                        dialogPanel.setText("Time: " + chunk);
                    }
                };

                protected void done() {
                    dialogPanel.setText("Done!");
                };
            }.execute();
            dialog.setVisible(true);
        }
    }

    private class DialogPanel extends JPanel {
        private JTextField textField = new JTextField(10);

        public DialogPanel() {
            setBackground(Color.BLACK);
            setPreferredSize(new Dimension(200, 200));
            add(textField);
        }

        public void setText(String text) {
            textField.setText(text);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        SwingExample mainPanel = new SwingExample();
        JFrame frame = new JFrame("SwingExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}