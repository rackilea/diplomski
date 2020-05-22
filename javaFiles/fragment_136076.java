import java.awt.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test extends JFrame {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.getContentPane().setBackground(Color.RED);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Field());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Field extends JPanel {

        public Field() {
            setOpaque(false);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 600);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 10; x++) {

                    g2d.setColor(getCurrentColor(x, y)); // get and set color of current square
                    {
                        if (x % 2 == 0) // if x even
                        {
                            if (y % 2 == 0) {
                                g2d.setColor(Color.lightGray); // if x even y even make gray
                            } else {
                                g2d.setColor(Color.pink); // if x even and y odd make pink
                            }
                        } else { // if odd even
                            if (y % 2 == 0) {
                                g2d.setColor(Color.pink); // if x odd and y even make pink
                            } else {
                                g2d.setColor(Color.lightGray); // if x odd and y odd make gray
                            }
                        }
                    }
                    if (x > 0 && x < 9 && y > 0 && y < 9) { // only if 0 < x < 9 and 0 < y < 9
                        g2d.fillRect(50 + 60 * x, 50 + 60 * y, 60, 60); // fill current rectangle
                    } else if (y == 0 && x > 0 && x < 9) {

                        g2d.setColor(Color.black);
                        g2d.drawString(Integer.toString(x), 50 + 60 * x, 50 + 60 * y);
                    }
                    /*  if (y == 2&& x== 1) {
                     *//* JLabel label = new JLabel();
                                        label.setLocation(x*60, y*60);
                                        label.setSize(60, 60);
                                        label.setLayout(new GridBagLayout());
                                        label.setIcon(new ImageIcon("C:/Users/Asus/Desktop/My Work/checkers/res/images/checkerimage.png"));
                                        add(label);*//*
                                }*/
                }
            }
            g2d.dispose();
        }

        private Color getCurrentColor(int x, int y) //set the color of current square
        {
            if (x % 2 == 0) // if x even
            {
                if (y % 2 == 0) {
                    return Color.red;
                } else {
                    return Color.blue;// if x even and y odd make blue
                }
            } else { // if odd even
                if (y % 2 == 0) {
                    return Color.blue; // if x odd and y even make blue
                } else {
                    return Color.red; // if x odd and y odd make red
                }
            }
        }

    }
}