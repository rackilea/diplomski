import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/** @see http://stackoverflow.com/questions/7801870 */
public class ScrollGroup extends JPanel {

    private static final int N = 8;
    private static final int NN = N * N;
    private static final int GAP = 5;
    private static final int SIZE = 32;

    public ScrollGroup() {
        this.setLayout(new GridLayout(N, N, GAP, GAP));
        for (int i = 0; i < NN; i++) {
            JLabel label = new JLabel();
            label.setOpaque(true);
            label.setBackground(Color.getHSBColor((float) i / NN, 1, 1));
            label.setPreferredSize(new Dimension(SIZE, SIZE));
            this.add(label);
        }
    }

    private void display() {
        JFrame f = new JFrame("ScrollGroup");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane sp = new JScrollPane(this);
        GroupLayout layout = new GroupLayout(f.getContentPane());
        f.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup().addComponent(sp)));
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup().addComponent(sp)));
        f.pack();
        f.setSize(N * SIZE, N * SIZE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ScrollGroup().display();
            }
        });
    }
}