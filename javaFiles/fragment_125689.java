import java.awt.*;
import javax.swing.*;
import java.net.*;
import javax.imageio.*;

class ImageExample implements Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ImageExample());
    }

    @Override
    public void run() {
        JFrame frame = new JFrame();
        JPanel content = new JPanel();
        content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        content.setBackground(Color.white);
        frame.setContentPane(content);
        //
        frame.setLayout(new BorderLayout(20, 20));
        JLabel icon = new JLabel(new ImageIcon(img));
        JLabel text = new JLabel("<html>" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + "<br>" +
            "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" + "<br>" +
            "cccccccccccccccccccccccccccccccccccccccccc" + "</html>");
        text.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        frame.add(icon, BorderLayout.WEST);
        frame.add(text, BorderLayout.CENTER);
        //
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static final Image img;
    static {
        try {
            URL url = new URL("http://i.stack.imgur.com/7bI1Y.jpg");
            img = ImageIO.read(url).getScaledInstance(48, 48, Image.SCALE_SMOOTH);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }
    }
}