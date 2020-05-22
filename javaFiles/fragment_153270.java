import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Page309_4 extends JFrame { //implements ActionListener 

  private JButton btnLeftMvmt, btnRightMvmt;
  private MyPanel myPanel;

  public Page309_4() {
    setTitle("Oval Mover");
    setSize(600, 150);
    setLayout(new BorderLayout());
    JPanel panel1, panel2;

    panel2 = new JPanel();

    myPanel = new MyPanel();
    InputMap im = myPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    ActionMap am = myPanel.getActionMap();

    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "Pressed.up");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "Pressed.down");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "Pressed.left");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "Pressed.right");

    am.put("Pressed.up", new VerticalMovementAction(-10, myPanel));
    am.put("Pressed.down", new VerticalMovementAction(10, myPanel));
    am.put("Pressed.left", new HorizontalMovementAction(-10, myPanel));
    am.put("Pressed.right", new HorizontalMovementAction(10, myPanel));

    btnLeftMvmt = new JButton("Left Translation");
    btnRightMvmt = new JButton("Right Translation");
    btnLeftMvmt.addActionListener(bleft -> {

    });
    btnRightMvmt.addActionListener(bright -> {

    });

    panel2.add(btnLeftMvmt);
    panel2.add(btnRightMvmt);

    add(myPanel);
    add(panel2, BorderLayout.SOUTH);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);

  }

  public class VerticalMovementAction extends AbstractAction {

    private int delta;
    private MyPanel myPanel;

    public VerticalMovementAction(int delta, MyPanel myPanel) {
      this.delta = delta;
      this.myPanel = myPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      myPanel.moveVerticallyBy(delta);
    }

  }

  public class HorizontalMovementAction extends AbstractAction {

    private int delta;
    private MyPanel myPanel;

    public HorizontalMovementAction(int delta, MyPanel myPanel) {
      this.delta = delta;
      this.myPanel = myPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      myPanel.moveHorizontallyBy(delta);
    }

  }

  class MyPanel extends JPanel {

    private int oval_x = (600 - 150) / 2;
    private int oval_y = (300 - 150) / 2;

    public MyPanel() {
      setBackground(Color.YELLOW);
    }

    @Override
    public Dimension getPreferredSize() {
      return new Dimension(600, 300);
    }

    public void moveVerticallyBy(int delta) {
      oval_y += delta;
      repaint();
    }

    public void moveHorizontallyBy(int delta) {
      oval_x += delta;
      repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponents(g);
      g.setColor(Color.RED);
      g.fillOval(oval_x, oval_y, 150, 150);
    }
  }

  public static void main(String[] args) {

    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        // TODO Auto-generated method stub
        Page309_4 f = new Page309_4();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
    });
  }
}