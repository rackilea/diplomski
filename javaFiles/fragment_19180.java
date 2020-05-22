import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;

public class MemoryGame extends JToggleButton implements ActionListener {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MemoryGame();
            }
        });
    }

    private Timer cdTimer;
    private JToggleButton[] buttons;
    ArrayList<String> iconList = new ArrayList();

    public MemoryGame() {
        JFrame jfrm = new JFrame();

        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout layout = new GridLayout(3, 4);

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(layout);

        createIcons();

        buttons = new JToggleButton[12];

        for (int i = 0; i < buttons.length; i++) {
            JToggleButton btn = new JToggleButton("~");
            btn.setFocusable(false);

            buttons[i] = btn;

//            buttons[i].setActionCommand(commandID[i]);
            buttons[i].addActionListener(this);

            gamePanel.add(buttons[i]);
        }

        //Collections.shuffle(Arrays.asList(buttons));
        jfrm.add(gamePanel, BorderLayout.CENTER);

        jfrm.pack();
        jfrm.setLocationRelativeTo(null);

        jfrm.setVisible(true);
    }

    private JToggleButton last;

    public void actionPerformed(ActionEvent e) {
        JToggleButton btn = (JToggleButton) e.getSource();
        firstClick(btn);
        if (last == null) {
            last = btn;
            return;
        }

        matching(btn, last);

        last = null;
    }

    private void firstClick(JToggleButton btn) {
        if (btn == buttons[0] || btn == buttons[1]) {
            btn.setText(iconList.get(0));
        } else if (btn == buttons[2] || btn == buttons[3]) {
            btn.setText(iconList.get(1));
        } else if (btn == buttons[4] || btn == buttons[5]) {
            btn.setText(iconList.get(2));
        } else if (btn == buttons[6] || btn == buttons[7]) {
            btn.setText(iconList.get(3));
        } else if (btn == buttons[8] || btn == buttons[9]) {
            btn.setText(iconList.get(4));
        } else if (btn == buttons[10] || btn == buttons[11]) {
            btn.setText(iconList.get(5));
        }
    }

    private void matching(JToggleButton btn, JToggleButton btn2) {
        if (btn.isSelected()) {
            btn.setEnabled(false);
            if (btn2.isSelected()) {
                btn2.setEnabled(false);
                if (!btn.getText().equals(btn2.getText())) {
                    startTime(btn, btn2);
                } else {
                    retirePair(btn, btn2);
                }
            }
        }
    }

    private void startTime(JToggleButton button, JToggleButton button2) {
        System.out.println("!!");
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("..");
                cdTimer.stop();
                button.setText("~");
                button2.setText("~");
                button.setEnabled(true);
                button2.setEnabled(true);

                button.setSelected(false);
                button2.setSelected(false);
            }

        };
        cdTimer = new Timer(1000, action);
        cdTimer.start();
    }

    private void unflipPair(JToggleButton btn, JToggleButton btn2) {
        btn.setEnabled(true);
        btn2.setEnabled(true);
        btn.setSelected(false);
        btn2.setSelected(false);
    }

    private void retirePair(JToggleButton btn, JToggleButton btn2) {
        btn.setEnabled(false);
        btn2.setEnabled(false);
        btn.setSelected(true);
        btn2.setSelected(true);
    }

    private void createIcons() {
        ImageIcon icon1 = new ImageIcon("1.png");
        ImageIcon icon2 = new ImageIcon("2.png");
        ImageIcon icon3 = new ImageIcon("3.png");
        ImageIcon icon4 = new ImageIcon("4.png");
        ImageIcon icon5 = new ImageIcon("5.png");
        ImageIcon icon6 = new ImageIcon("6.png");

        iconList.add("1");
        iconList.add("2");
        iconList.add("3");
        iconList.add("4");
        iconList.add("5");
        iconList.add("6");

    }

}