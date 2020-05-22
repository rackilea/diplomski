import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Board {

    public static void main(String[] args) {
        new Board();
    }

    public Board() {
        JButton[] button = new JButton[40];
        int i = 0;
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(20, 20, 15, 15));
        Action action = new Action(frame);
        while (i < 40) {
            button[i] = createButton(i);
            button[i].addActionListener(action);
            frame.add(button[i]);
            i++;
        }
        action.setCount(i);
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JButton createButton(int index) {

        return new JButton("button" + index);

    }

    public class Action implements ActionListener {

        private JFrame frame;
        private int count;

        public Action(JFrame frame) {
            this.frame = frame;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = createButton(count);
            btn.addActionListener(this);
            frame.add(btn);
            frame.revalidate();
            count++;
        }
    }
}