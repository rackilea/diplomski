import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        new DownloadFrame();
    }

    private static class DownloadFrame extends JFrame {

        private JButton downloadButton;
        private JTextField threadIdTextField;
        private JTextArea downloadStatusTextArea;
        private JScrollPane scrollPane;
        private JTextField downloadLocationTextField;
        private JButton downloadLocationButton;

        private JPanel North;
        private JPanel South;
        private JPanel ProgressBarPanel;

        private Map<String, JProgressBar> progressBarMap;

        public DownloadFrame() {
            InitComponents();
            AddComponents();
            AddActionListeners();

            pack();
            setVisible(true);
            //setSize(700, 300);
        }

        private void InitComponents() {
            setLayout(new BorderLayout());
            downloadButton = new JButton("Dowload");
            threadIdTextField = new JTextField(6);
            downloadStatusTextArea = new JTextArea(10, 30);
            scrollPane = new JScrollPane(downloadStatusTextArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            downloadLocationTextField = new JTextField(40);
            downloadLocationButton = new JButton("...");
            North = new JPanel(new FlowLayout());
            South = new JPanel(new FlowLayout());
            ProgressBarPanel = new JPanel(new GridLayout(0, 1));
            ProgressBarPanel.setBorder(new LineBorder(Color.black));
            ProgressBarPanel.setPreferredSize(new Dimension(300,20));
            progressBarMap = new HashMap<String, JProgressBar>();
        }

        private void AddComponents() {
            North.add(threadIdTextField);
            North.add(downloadButton);
            add(North, BorderLayout.NORTH);

            add(ProgressBarPanel, BorderLayout.EAST);

            South.add(downloadLocationTextField);
            South.add(downloadLocationButton);
            add(South, BorderLayout.SOUTH);

            add(scrollPane, BorderLayout.WEST);
        }

        private void AddActionListeners() {
            downloadButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    addNewProgessBar(threadIdTextField.getText());
                }
            });
        }

        public void addNewProgessBar(String threadId) {
            JProgressBar progressBar = new JProgressBar();
            progressBar.setStringPainted(true);
            progressBarMap.put(threadId, progressBar);
            drawProgessBars();
        }

        void drawProgessBars() {
            ProgressBarPanel.removeAll();
            for (JProgressBar progressBar : progressBarMap.values()) {
                ProgressBarPanel.add(progressBar);
            }
            validate();
            repaint();
        }

    }
}