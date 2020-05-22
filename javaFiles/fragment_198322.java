import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MoveIt extends JApplet {

    public void init() {
        setLayout(new BorderLayout());
        add(new ControlPane());
    }

    public class CupPane extends JPanel {

        private Image cup;
        public int top = 15;
        public int left = 15;

        public CupPane() {
            cup = getImage(getDocumentBase(), "cup.png");
            setBackground(Color.BLUE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(cup, left, top, this);
        }

        public void moveUp() {
            top -= 15;
            repaint();
        }

        public void moveLeft() {
            left -= 15;
            repaint();
        }

        public void moveRight() {
            left += 15;
            repaint();
        }

        public void moveDown() {
            top += 15;
            repaint();
        }

        public void center() {
            int width = getWidth();
            int height = getHeight();
            top = (height - cup.getHeight(this)) / 2;
            left = (width - cup.getWidth(this)) / 2;
        }
    }

    public class ControlPane extends JPanel {

        private JPanel keyPad;
        public int top = 15;
        public int left = 15;
        private boolean foundKey;
        private JButton[] keysArray;
        private CupPane cupPane;

        public ControlPane() {
            keyPad = new JPanel();
            keysArray = new JButton[5];
            cupPane = new CupPane();

            //Create Buttons
            keysArray[0] = new JButton("Up");
            keysArray[1] = new JButton("Left");
            keysArray[2] = new JButton("Right");
            keysArray[3] = new JButton("Down");
            keysArray[4] = new JButton("Center");

            keysArray[0].setActionCommand("Up");
            keysArray[1].setActionCommand("Left");
            keysArray[2].setActionCommand("Right");
            keysArray[3].setActionCommand("Down");
            keysArray[4].setActionCommand("Center");

            setBackground(Color.blue);

            //Sets the layout manager for the frame
            setLayout(new BorderLayout());

            //Sets the layout manager for the Panel
            keyPad.setLayout(new BorderLayout());

            //Add Buttons to keypad panel
            keyPad.add(keysArray[0], BorderLayout.NORTH);
            keyPad.add(keysArray[1], BorderLayout.WEST);
            keyPad.add(keysArray[2], BorderLayout.EAST);
            keyPad.add(keysArray[3], BorderLayout.SOUTH);
            keyPad.add(keysArray[4], BorderLayout.CENTER);

            add(cupPane, BorderLayout.CENTER);
            add(keyPad, BorderLayout.SOUTH);

            ActionHandler handler = new ActionHandler();
            //adds actionlistener to the buttons
            for (int i = 0; i < keysArray.length; i++) {
                keysArray[i].addActionListener(handler);
            }

        }

        protected class ActionHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String arg = e.getActionCommand();

                if ("Up".equals(arg)) {
                    cupPane.moveUp();
                } else if ("Left".equals(arg)) {
                    cupPane.moveLeft();
                } else if ("Right".equals(arg)) {
                    cupPane.moveRight();
                } else if ("Down".equals(arg)) {
                    cupPane.moveDown();
                } else if ("Center".equals(arg)) {
                    cupPane.center();
                }
                repaint();
            }
        }
    }
}