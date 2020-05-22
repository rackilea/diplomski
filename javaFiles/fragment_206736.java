import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MakeAQuiz {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                new MakeAQuiz();
            }
        });
    }

    private JPanel start, base, fields, buttonz, question;
    private String[] labels = {"Enter your question: ", "Answer 1: ", "Answer 2: ", "Answer 3: ", "Answer 4: "};
    private JButton[] buttons = {new JButton("<<Go back"), new JButton("I'm done"), new JButton("Next>>")};
    private JFrame makeFrame;

    public MakeAQuiz() {
        start = new JPanel(new CardLayout());
        start.add(makePanel(), "1");

        makeFrame = new JFrame();
        makeFrame.add(start);

        buttonz = new JPanel(new FlowLayout());

        final CardLayout layout = (CardLayout) start.getLayout();

        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[0].setEnabled(false);
                buttons[2].setEnabled(false);
            }
        });

        buttons[2].addActionListener(new ActionListener() {
      @Override
            public void actionPerformed(ActionEvent e) {
                int count = start.getComponentCount();
                start.add(new JLabel(Integer.toString(count), JLabel.CENTER), Integer.toString(count));
                layout.next(start);
            }
        });

        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.previous(start);
            }
        });

        buttonz.add(buttons[0]);
        buttonz.add(buttons[1]);
        buttonz.add(buttons[2]);

        makeFrame.add(buttonz, BorderLayout.SOUTH);

        makeFrame.pack();
        makeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        makeFrame.setVisible(true);
    }

    public JFrame getJFrame() {
        return makeFrame;
    }

    public JPanel makePanel() {
        question = new JPanel(new FlowLayout());
        fields = new JPanel(new GridBagLayout());
        base = new JPanel(new BorderLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.weighty = 0.5; //adds padding between the fields vertically

        for (int i = 1; i < 5; i++) {
            c.gridy++; //puts each field in a seperate line/row
            JLabel label = new JLabel(labels[i]);
//            c.fill = GridBagConstraints.HORIZONTAL;
            fields.add(label, c);
            JTextField textField = new JTextField(20);
            fields.add(textField, c);
        }

        JLabel l = new JLabel(labels[0]);
        JTextField t = new JTextField(30);
        question.add(l);
        question.add(t);

        base.add(question, BorderLayout.NORTH);
        base.add(fields, BorderLayout.CENTER);

        return base;
    }

}