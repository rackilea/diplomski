import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class MovingJPanel {

    public static void main(String[] args) {
    JFrame frame = new JFrame("Frogger");

    frame.pack();
    frame.setVisible(true);
    frame.setResizable(true);
    frame.setLocationRelativeTo(null);
    frame.setSize(400,400);
    JPanel abc = new JPanel();
    abc.setBackground(Color.CYAN);
    abc.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "left");
    abc.getActionMap().put("left", new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            System.out.println("LEFT");}
    });
    abc.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "right");
    abc.getActionMap().put("right", new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            System.out.println("ROIGHT");}
    });
    abc.getInputMap().put(KeyStroke.getKeyStroke("UP"), "up");
    abc.getActionMap().put("up", new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            System.out.println("UP");}
    });
    abc.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "down");
    abc.getActionMap().put("down", new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            System.out.println("DOWN");}
    });

    abc.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            System.out.println("Focus Gained");
        }
        @Override
        public void focusLost(FocusEvent e) {
            System.out.println("Focus Lost");
        }  
});
    abc.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            JPanel p = (JPanel)e.getSource();
            p.requestFocus();
        } 
});

    abc.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseEntered(MouseEvent e) {
           JPanel p = (JPanel)e.getSource();
            p.requestFocus();
        }

});
    frame.getContentPane().add(abc,"Center");
    frame.getContentPane().add(new JButton("Click Me"),"North");
    abc.requestFocusInWindow();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
}