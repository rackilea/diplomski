import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

class Test {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                final Model model = new Model();
                final Control control = new Control(model);
                final View view = new View(model, control);

                final JFrame frame = new JFrame("MVC Example");
                frame.getContentPane().add(view);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }

        });
    }

    static class Model extends Observable {

        private int number;

        void setNumber(int newValue) {
            number = newValue;
            setChanged();
            notifyObservers(number);
        }

        int getNumber() {
            return number;
        }

    }

    static class View extends JPanel {

        View(Model model, Control control) {
            final JLabel label = new JLabel(Integer.toString(model.getNumber()));
            final JButton button = new JButton("Click me!");
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    control.buttonPressed();
                }

            });

            setLayout(new BorderLayout());
            add(label);
            add(button, BorderLayout.SOUTH);

            model.addObserver(new Observer() {

                @Override
                public void update(Observable o, Object arg) {
                    label.setText(Integer.toString((int) arg));
                }

            });
        }

    }

    static class Control {

        private Model model;

        Control(Model model) {
            this.model = model;
        }

        void buttonPressed() {
            model.setNumber(model.getNumber() + 1);
        }

    }

}