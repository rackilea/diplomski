import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DoorMatrix extends JPanel {

    static JFrame f = new JFrame();
    private static JButton[][] buttons;
    int x = 0;
    int y = 0;

    public DoorMatrix(int row, int col) {
        super(new GridLayout(row, col));
        buttons = new JButton[row][col];

        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "up");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");

        ActionMap am = getActionMap();
        am.put("up", new MoveAction(0, -1));
        am.put("down", new MoveAction(0, 1));
        am.put("left", new MoveAction(-1, 0));
        am.put("right", new MoveAction(1, 0));

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton(new ButtonAction(j, i));
                add(buttons[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                int a = 0;
                int b = 7;
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.add(new DoorMatrix(12, 9));
                while (a < 2) {
                    while (b < 12) {
                        buttons[b][a].setVisible(false);
                        b++;
                    }
                    a++;
                    b = 7;
                }
                a = 4;
                b = 0;
                while (b < 12) {
                    buttons[b][a].setVisible(false);
                    b++;
                }
                b = 7;
                a = 7;
                while (a < 9) {
                    while (b < 12) {
                        buttons[b][a].setVisible(false);
                        b++;
                    }
                    a++;
                    b = 7;
                }
                f.pack();
                f.setVisible(true);
                f.setResizable(false);
            }
        });
    }

    public class ButtonAction extends AbstractAction {

        private int row, col;

        protected ButtonAction(int j, int i) {
            putValue(NAME, (j + 1) + ", " + (i + 1));
            row = i;
            col = j;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Look, button @ " + getCol() + "x" + getRow() + " was activated, that was easy...");
        }

    }

    public class MoveAction extends AbstractAction {

        private int colDelta;
        private int rowDelta;

        public MoveAction(int colDelta, int rowDelta) {
            this.colDelta = colDelta;
            this.rowDelta = rowDelta;
        }

        public int getColDelta() {
            return colDelta;
        }

        public int getRowDelta() {
            return rowDelta;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Component owner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
            if (owner instanceof JButton) {
                JButton btn = (JButton) owner;
                Action action = btn.getAction();
                if (action instanceof ButtonAction) {
                    ButtonAction ba = (ButtonAction) action;
                    int row = ba.getRow();
                    int col = ba.getCol();

                    do {
                        row += getRowDelta();
                        col += getColDelta();
                        if (row < 0) {
                            row = buttons.length - 1;
                        } else if (row >= buttons.length) {
                            row = 0;
                        }

                        if (col < 0) {
                            col = buttons[row].length - 1;
                        } else if (col >= buttons[row].length) {
                            col = 0;
                        }
                    } while (!buttons[row][col].isVisible());

                    buttons[row][col].requestFocusInWindow();
                }
            }
        }

    }
}