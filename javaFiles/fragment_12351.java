import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ResizeTextArea {

    public static final int CHAT_ROW_LIMIT = 4;

    public static void main(String[] args) {
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(200, 200));
        topPanel.setBackground(Color.WHITE);

        final JTextArea chatArea = new JTextArea();
        final JScrollPane scrollPane = new JScrollPane(chatArea);

        final JPanel mainPanel = new JPanel(new BorderLayout(5,5));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        mainPanel.add(topPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        chatArea.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLineCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLineCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLineCount();
            }

            private void updateLineCount() {
                int lineCount = chatArea.getLineCount();
                if (lineCount <= CHAT_ROW_LIMIT) {
                    chatArea.setRows(lineCount);
                    mainPanel.revalidate();
                }
            }
        });

        JFrame f = new JFrame("ResizeTextArea");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(mainPanel);
        f.pack();
        f.setVisible(true);
    }
}