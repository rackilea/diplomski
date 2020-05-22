import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class CreatingSpeciesPanel extends JPanel {
    public static final String INITIALIZING = "Initializing...";
    public static final String DONE = "DONE!";
    private static final int PREF_W = 480;
    private static final int PREF_H = 150;
    private static final int GAP = 20;
    private static final float TITLE_SIZE = 24f;

    private JLabel title = new JLabel(INITIALIZING, SwingConstants.CENTER);
    private JProgressBar progressBar = new JProgressBar();

    public CreatingSpeciesPanel() {
        title.setFont(title.getFont().deriveFont(Font.BOLD, TITLE_SIZE));
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(progressBar, BorderLayout.PAGE_END);

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        add(title, BorderLayout.PAGE_START);
        add(centerPanel, BorderLayout.CENTER);

    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    public void setValue(int value) {
        progressBar.setValue(value);
    }

    public void setTitleLabelText(String text) {
        title.setText(text);
    }

    private static void createAndShowGui() {
        final CreatingSpeciesPanel creatingSpeciesPanel = new CreatingSpeciesPanel();
        final JFrame mainFrame = new JFrame("Main Frame");

        JButton createSpeciesBtn = new JButton(new AbstractAction("Create Species") {

            @Override
            public void actionPerformed(ActionEvent e) {
                creatingSpeciesPanel.setTitleLabelText(CreatingSpeciesPanel.INITIALIZING);
                final JDialog dialog = new JDialog(mainFrame, "Creating Species", ModalityType.APPLICATION_MODAL);
                dialog.add(creatingSpeciesPanel);
                dialog.pack();
                dialog.setLocationRelativeTo(mainFrame);

                new Timer(200, new ActionListener() {
                    private int doneCount = 0;
                    private int value = 0;
                    private static final int MAX_DONE_COUNT = 10;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (value < 100) {

                            value += (int) Math.random() * 5 + 5;
                            value = Math.min(100, value);

                            creatingSpeciesPanel.setValue(value);
                            if (value == 100) {
                                creatingSpeciesPanel.setTitleLabelText(CreatingSpeciesPanel.DONE);
                            }
                        } else {
                            // let's display the dialog for 2 more seconds
                            doneCount++;
                            if (doneCount >= MAX_DONE_COUNT) {
                                ((Timer) e.getSource()).stop();
                                dialog.setVisible(false);
                            }
                        }
                    }
                }).start();

                dialog.setVisible(true);
            }
        });

        JPanel panel = new JPanel();
        panel.add(createSpeciesBtn);
        panel.setPreferredSize(new Dimension(500, 400));

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().add(panel);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}