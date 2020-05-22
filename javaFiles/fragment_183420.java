import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Quizx extends JFrame {
private JPanel panel;
private JTextField textfield;
private JLabel ansLabel;

public Quizx() {
    panel = new JPanel(new FlowLayout());
    this.getContentPane().add(panel);
    addLabel();
    addTextField();
    addButtons();
    addAnswerLabel();
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setTitle("Quiz 4");
    this.setSize(220, 150);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setVisible(true);
}

private void addTextField() {
    textfield = new JTextField();
    textfield.setColumns(9);
    panel.add(textfield);
}

private void addButtons() {
    JButton multButton = new JButton("x2");
    JButton divButton = new JButton("/3");
    panel.add(multButton);
    panel.add(divButton);
    addMultListener(multButton);
    addDivListener(divButton);
}

private void addLabel() {
    JLabel valueLabel = new JLabel("Enter a value between 1 and 20: ");
    panel.add(valueLabel);
}

private void addAnswerLabel() {
    ansLabel = new JLabel();
    panel.add(ansLabel);
}

private void addMultListener(JButton button) {
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            ansLabel.setText(String.valueOf(Integer.parseInt(textfield.getText().trim()) * 2));

        }
    });
}

private void addDivListener(JButton button) {
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            ansLabel.setText(String.valueOf(Double.parseDouble(textfield.getText().trim()) /3));

        }
    });
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            new Quizx();
        }
    });
}
}