import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import javax.swing.*;
import java.net.URL;

//public class TestingGrounds extends JFrame {
public class TestingGrounds {

    //declarations
    JButton snakeButton;
    JPanel snakeButtonPanel;
    JFrame window;
    TitleScreenHandler tsHandler = new TitleScreenHandler();

    //constructor
    public TestingGrounds() {
        //main JFrame
        window = new JFrame("Title Screen");
        try {
            JPanel imagePanel = new ImagePanel();
            imagePanel.setLayout(new BorderLayout());
            window.add(imagePanel);
            //window.setResizable(false);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Don't guess sizes needed. They will be wrong on other 
            // PLAFs or platforms.
            //window.setSize(850, 600);

            // should be last
            //window.setVisible(true);
            window.setLocationRelativeTo(null);
            //window.setLayout(null);

            //con = window.getContentPane();
            //panel for the button to go to the snake game
            snakeButtonPanel = new JPanel(new GridBagLayout());
            snakeButtonPanel.setOpaque(false);
            //snakeButtonPanel.setBounds(100, 100, 600, 150);

            //button to go to snake game
            snakeButton = new JButton("Snake");
            snakeButton.setMargin(new Insets(10,40,10,40));
            snakeButton.setBackground(Color.BLACK);
            snakeButton.setForeground(Color.WHITE);
            snakeButton.setFont(new Font("Times New Roman", Font.ITALIC, 30));
            snakeButton.addActionListener(tsHandler);
            snakeButton.setFocusPainted(false);
            //adding button to panel
            snakeButtonPanel.add(snakeButton);
            //adding panel to container
            //con.add(snakeButtonPanel);
            // Adding the container to imagePanel
            imagePanel.add(snakeButtonPanel);

            //setting the panel as visible
            snakeButtonPanel.setVisible(true);

            window.pack();
            window.setVisible(true);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }

    //main method for running constructor
    public static void main(String[] args) {
        new TestingGrounds();
    }

    //what to do if the button is pressed
    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            //goes to main game screen if start button is pressed
            //new SnakeGame();
            JOptionPane.showMessageDialog(snakeButton, "Snake Game");
        }
    }
}
//class for using the gif

class ImagePanel extends JPanel {

    Image image;

    public ImagePanel() throws MalformedURLException {
        image = Toolkit.getDefaultToolkit().createImage(
                new URL("https://i.stack.imgur.com/OtTIY.gif"));
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(image, 1);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public Dimension getPreferredSize() {
        // this allows us to pack() the window around the image
        return (new Dimension(image.getWidth(this), image.getHeight(this)));
    }
}