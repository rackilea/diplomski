import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class Test extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Test().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private JPanel cards;
    private CardLayout cardLayout;
    private static final String studentTag = "student";
    private static final String teacherTag = "teacher";

    public Test() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel(new GridLayout(2,1));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(contentPane);

        JPanel radioPanel = new JPanel(new GridLayout(0,1));
        JRadioButton studentButton = new JRadioButton("Student");
        studentButton.setActionCommand(studentTag);
        studentButton.setSelected(true);
        JRadioButton teacherButton = new JRadioButton("Teacher");
        teacherButton.setActionCommand(teacherTag);
        ButtonGroup group = new ButtonGroup();
        group.add(studentButton);
        group.add(teacherButton);
        radioPanel.add(studentButton);
        radioPanel.add(teacherButton);
        contentPane.add(radioPanel);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        JPanel studentCard = new JPanel(new BorderLayout());
        studentCard.add(new Label("Student card"), BorderLayout.CENTER);
        JPanel teacherCard = new JPanel(new BorderLayout());
        teacherCard.add(new Label("Teacher card"), BorderLayout.CENTER);
        cards.add(studentCard, studentTag);
        cards.add(teacherCard, teacherTag);
        contentPane.add(cards);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, e.getActionCommand());
            }
        };
        studentButton.addActionListener(listener);
        teacherButton.addActionListener(listener);
        pack();
    }
}