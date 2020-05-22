import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Door");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                TempDoorPanel panel = new TempDoorPanel();
                frame.add(panel);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
class Door {

    private String state;
    private String message;

    public Door(String state) {
        this.state = state;
        message = "The door is currently closed.";
    }

    public void drawOpenDoor(Graphics page) {
        page.setColor(Color.GREEN);
        page.drawRect(0, 0, 10, 10);
    }
}

class TempDoorPanel extends JPanel {

    private Door door;
    private JTextField currentStateOfDoor;
    private JButton openDoor;

    public TempDoorPanel() {
        super.setLayout(new BorderLayout());
        door = new Door("closed");

        currentStateOfDoor = new JTextField(14);
        //AcurrentStateOfDoor.setText(door.getMessage());
        super.add(currentStateOfDoor, BorderLayout.NORTH);

        openDoor = new JButton("Open Door");

        final JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                // if (door.isOpen()) {
                door.drawOpenDoor(grphcs);
                // }
                // isOpen is a boolean method from Door class.

            }
        };
        drawingPanel.setBackground(Color.blue);
        add(drawingPanel);

        class openDoorListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                //door.open();
                repaintText();
                drawingPanel.repaint();//so paint component of drawing panel is called
            }
        }

        openDoorListener openlistener = new openDoorListener();
        openDoor.addActionListener(openlistener);

        JPanel holder = new JPanel();
        holder.add(openDoor);
        super.add(holder, BorderLayout.SOUTH);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    private void repaintText() {
        // currentStateOfDoor.setText(door.getMessage());
        // These methods are from Door class.
    }
}