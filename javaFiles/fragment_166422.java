import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JPanel {

    private boolean whichColor = true;
    private Color rainbowColor;

    public void paintComponent(Graphics g) {

        int margin = 4;
        int red = 0;
        int green = 255;
        int blue = 0;

        if (whichColor) {
            red = 255;
            blue = 0;
            whichColor = false;
        } else {
            red = 0;
            blue = 255;
            whichColor = true;
        }
        rainbowColor = new Color(red, green, blue);
        super.paintComponent(g);
        Font customFont = new Font("Dialog", Font.BOLD, 20);
        g.setFont(customFont);
        g.setColor(new Color(0, 0, 0));
        g.drawString("TEXT", 20, 30);
//        randomiseColor(randomColor);
        g.setColor(rainbowColor);
        System.out.println(rainbowColor);
        g.drawString("TEXT", 22, 32);
        g.drawRect(margin, margin, getWidth() - margin * 2 - 1, getHeight() - margin * 2 - 1);

    }

    public static void main(String[] args) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        RandomColorOnClick colorListener = new RandomColorOnClick();
        ButtonHandler listener = new ButtonHandler();

        Menu main_text = new Menu();
        JPanel main_content = new JPanel();
        JFrame main_window = new JFrame("Some random text");
        JButton main_exit_button = new JButton("Exit");

        main_content.addMouseListener(colorListener);

        main_window.setContentPane(main_content);
        main_window.setSize(800, 600);
        main_window.setLocation(((int) width / 2) - 400, ((int) height / 2) - 300);
        main_window.setVisible(true);
        main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        main_content.setLayout(new BorderLayout());
        main_content.add(main_text, BorderLayout.CENTER);

        main_exit_button.addActionListener(listener);
    }

}

class RandomColorOnClick implements MouseListener {

    public void mousePressed(MouseEvent evt) {
        Component source = (Component) evt.getSource();
        source.repaint();
    }

    public void mouseClicked(MouseEvent evt) {
    }

    public void mouseReleased(MouseEvent evt) {
    }

    public void mouseEntered(MouseEvent evt) {
    }

    public void mouseExited(MouseEvent evt) {
    }

}