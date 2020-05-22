import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class UIBuilder {
  private static final int NONE = -1;

  private static final int BORDER = 3;

  private JFrame frame = new JFrame("Builder");

  private JToolBar toolbar = new JToolBar();

  private JPanel main = new JPanel();

  private int startX = NONE;

  private int startY = NONE;

  private int prevX = NONE;

  private int prevY = NONE;

  private boolean resize = false;

  public UIBuilder() {
    frame.setBounds(100, 100, 600, 450);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add(toolbar, BorderLayout.PAGE_START);
    frame.getContentPane().add(main, BorderLayout.CENTER);
    frame.setVisible(true);
    buildToolbox();
    buildMainPanel();
  }

  private void buildToolbox() {
    JButton button = new JButton("Button");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JButton btn = new JButton("Button");
        addComponent(btn);
      }
    });
    toolbar.add(button);
  }

  private void buildMainPanel() {
    main.setLayout(null);
  }

  private void addComponent(JComponent comp) {
    comp.setBounds(10, 10, 80, 24);

    comp.addMouseListener(new MouseAdapter() {
      public void mouseReleased(MouseEvent e) {
        startX = NONE;
        startY = NONE;
        ((JComponent) e.getSource()).setCursor(Cursor.getDefaultCursor());
      }

      public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
      }
    });

    comp.addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
        JComponent source = (JComponent) e.getSource();
        int x = e.getX();
        int y = e.getY();
        Rectangle bounds = source.getBounds();
        resize = x < BORDER || y < BORDER || Math.abs(bounds.width - x) < BORDER || Math.abs(bounds.height - y) < BORDER;
        if (resize) {
          // TODO: there are a lot of resize cursors here, this is just of proof of concept
          source.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
        } else {
          source.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }
      }

      public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (startX != NONE && startY != NONE) {
          JComponent source = (JComponent) e.getSource();
          Rectangle bounds = source.getBounds();
          int deltaX = x - startX;
          int deltaY = y - startY;
          if (resize) {
            // TODO: handle all resize cases, left, right,...
            source.setSize(Math.max(10, bounds.width + x - prevX), Math.max(10, bounds.height + y - prevY));
          } else {
            source.setLocation(bounds.x + deltaX, bounds.y + deltaY);
          }
          // TODO: make sure you don't resize it as much as it disappears
          // TODO: make sure you don't move it outside the main panel
        } else {
          startX = x;
          startY = y;
        }
        prevX = x;
        prevY = y;
      }
    });
    main.add(comp);
    main.validate();
    main.repaint();
  }

  public static void main(String[] args) {
    new UIBuilder();
  }

}