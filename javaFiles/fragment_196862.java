import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class firstGUI extends JFrame
     implements ActionListener {

     private boolean showText = false;
     private boolean showRect = true;
     private boolean showOval = false;
     private JButton text;
     private JButton oval;
     private JButton rectangle;
     private JPanel buttonPanel;
     private DrawStuff drawPanel = new DrawStuff();

     public firstGUI() {
         super("First GUI");
         setSize(512, 512);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         buttonPanel = new JPanel();
         buttonPanel.setLayout(new GridLayout(1, 3));

         text = new JButton("Text");
         text.addActionListener(this);
         buttonPanel.add(text);

         oval = new JButton("Oval");
         oval.addActionListener(this);
         buttonPanel.add(oval);

         rectangle = new JButton("Rectangle");
         rectangle.addActionListener(this);
         buttonPanel.add(rectangle);


         Container contentPane = this.getContentPane();
         contentPane.add(buttonPanel, BorderLayout.NORTH);
         add(drawPanel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == text) {
            showText = true;
            repaint();
        } else if (source == oval) {
            showOval = true;
            repaint();
        } else if (source == rectangle) {
            showRect = true;
            repaint();
        }
    }

    public static void main(String[] args) {
        firstGUI myTest = new firstGUI();
        myTest.setVisible(true);
    }

    class DrawStuff extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (showText) {
                g.drawString("Hello", getHeight() / 2, getWidth() / 2);
                showText = false;
            } else if (showOval) {
                g.drawOval(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
                showOval = false;
            } else if (showRect) {
                g.drawRect(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
                showRect = false;
            }
        }
    }
}