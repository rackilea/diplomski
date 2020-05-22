import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.*;

@SuppressWarnings("serial")
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
            dialogPanel.clearList();
            if (dialog == null) {
                Window win = SwingUtilities.getWindowAncestor(SwingExample.this);
                dialog = new JDialog(win, "Dialog", ModalityType.MODELESS);
                dialog.add(dialogPanel);
                dialog.pack();
                dialog.setLocationRelativeTo(win);
            }
            new SwingWorker<Void, String>() {
                @Override
                protected Void doInBackground() throws Exception {
                    String[] tabelements = { "test1", "test2", "test3", "test4", "test5" };
                    for (int i = 0; i < 5; i++) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        publish(tabelements[i]);
                    }
                    return null;
                }

                protected void process(java.util.List<String> chunks) {
                    for (String chunk : chunks) {
                        dialogPanel.addText(chunk);
                    }
                };

                protected void done() {
                    dialogPanel.addText("Done!");
                };
            }.execute();
            dialog.setVisible(true);
        }
    }

    private class DialogPanel extends JPanel {
        private DefaultListModel<String> listModel = new DefaultListModel<>();
        private JList<String> jList = new JList<>(listModel);

        public DialogPanel() {
            jList.setPrototypeCellValue("ABCDEFG HIJKLMNOP");
            jList.setVisibleRowCount(6);
            JScrollPane scrollPane = new JScrollPane(jList);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            setBackground(Color.BLACK);
            setPreferredSize(new Dimension(200, 200));
            add(scrollPane);
        }

        public void clearList() {
            listModel.clear();
        }

        public void addText(String text) {
            listModel.addElement(text);
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