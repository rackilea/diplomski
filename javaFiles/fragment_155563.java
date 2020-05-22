import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestLayout {

    public static void main(String[] args) {
        new TestLayout();
    }

    public TestLayout() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(GamePanel2());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    @SuppressWarnings("unused")
    JComponent GamePanel2() {

        JComponent GamePanel = new JPanel();
        GamePanel.setOpaque(false);

        //Setting up the gridbaglayout
        GamePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbLayout = new GridBagConstraints();

        /*//Creating a button to test out switching panels
         * 
         JButton testButton = new JButton ("test");
         GamePanel.add(testButton);*/
        //Creating buttons for answering the quiz
        gbLayout.gridx = 0;
        gbLayout.gridy = 0;
        gbLayout.weightx = 1.0;
        gbLayout.anchor = GridBagConstraints.NORTHWEST;
        gbLayout.insets = new Insets(20, 20, 20, 20);
        JButton AnswerOneButton = new JButton("Answer One");
        GamePanel.add(AnswerOneButton, gbLayout);

        gbLayout.gridx = 1;
        gbLayout.anchor = GridBagConstraints.NORTHEAST;
        JButton AnswerTwoButton = new JButton("Answer Two");
        GamePanel.add(AnswerTwoButton, gbLayout);

        gbLayout.gridx = 0;
        gbLayout.gridy = 1;
        gbLayout.anchor = GridBagConstraints.SOUTHWEST;
        JButton AnswerThreeButton = new JButton("Answer Three");
        GamePanel.add(AnswerThreeButton, gbLayout);

        gbLayout.gridx = 1;
        gbLayout.gridy = 1;
        gbLayout.weightx = 1.0;
        gbLayout.anchor = GridBagConstraints.SOUTHEAST;
        JButton AnswerFourButton = new JButton("Answer Four");
        GamePanel.add(AnswerFourButton);
        GamePanel.add(AnswerFourButton, gbLayout);

        return GamePanel;
    }

}