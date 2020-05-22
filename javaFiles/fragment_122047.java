import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SimpleDrawing {

    public SimpleDrawing() {
        final DrawingPanel panel = new DrawingPanel();

        final JTextField field = new JTextField(15);

        JButton button = new JButton("Change name");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String someString = field.getText();
                if (!someString.isEmpty()) {
                    panel.setString(someString);
                }
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(field);
        bottomPanel.add(button);

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public class DrawingPanel extends JPanel {
        private String someString = "Stackoverflow";

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString(someString, 75, 75);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension (300, 100);
        }

        public void setString(String someString) {
            this.someString = someString;
            repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new SimpleDrawing();
            }
        });
    }  
}