import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.Timer;

/**
 * @see http://stackoverflow.com/a/38051563/230513
 */
public class Test {

    private final Random r = new Random();

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JToggleButton button = new JToggleButton("0000");
        f.add(button);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        Timer t = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.isSelected() | button.getModel().isPressed()) {
                    button.setText(String.valueOf(r.nextInt(9000) + 1000));
                }
            }
        });
        t.start();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Test()::display);
    }
}