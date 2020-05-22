import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GuessingGameGui implements ActionListener {

    JFrame window = new JFrame();
    JButton button;
    JTextField input;
    JPanel cp = new JPanel();
    JPanel sp = new JPanel();
    int RN = (int) (10 * Math.random()) + 1;
    JPanel subpanel = new JPanel();
    int attempts = 1;

    JLabel result;

    public GuessingGameGui() {

        window.setTitle("Guessing Game");
        window.setSize(400, 300);
        boolean go = false;
        int correct;

        JPanel np = new JPanel();
        np.setLayout(new BorderLayout());
        window.add(np, BorderLayout.NORTH);
        JLabel question;
        question = new JLabel("Guess a number between 1 and 10:");
        np.add(question);

        cp.setLayout(new BorderLayout());

        button = new JButton("Guess");
        button.addActionListener(this);
        subpanel.add(button);

        input = new JTextField(2);
        subpanel.add(input);
        cp.add(subpanel);
        window.add(cp, BorderLayout.CENTER);

        sp.setLayout(new BorderLayout());
        window.add(sp, BorderLayout.SOUTH);

        result = new JLabel(" ");
        sp.add(result);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Guess")) {

            String text = input.getText();
            int number = Integer.parseInt(text);

            System.out.println(RN);
            if (RN != number) {

                result.setText("Sorry try again");
                sp.setBackground(Color.GRAY);
                attempts++;

            } else {
                result.setText("Good guess well done!");
                sp.setBackground(Color.GREEN);
            }
            sp.setVisible(true);

        }

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                GuessingGameGui g = new GuessingGameGui();
            }
        });
    }

}