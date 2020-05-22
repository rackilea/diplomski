import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Main {

public static void main(String[] args) {

    final Frame mainFrame = new OptionOne();
    Button button = new Button("Button");
    final Label label = new Label();

    label.setBounds(150, 220, 50, 30);
    label.setText("0");
    button.setBounds(40, 35, 50, 50);

    label.addPropertyChangeListener(label.getText(), new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            mainFrame.addNotify();
        }
    });

    button.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int value = Integer.parseInt(label.getText());
            label.setText(String.valueOf(value + 1));
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    });

    mainFrame.add(label);
    mainFrame.add(button);
 }
}

class OptionOne extends Frame {

   OptionOne() {
    setTitle("Final Project Option 1");
    setSize(300, 300);
    show();
   }
}