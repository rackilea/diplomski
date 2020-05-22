import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ClientPanel extends JPanel {
    private static final String COMMON = "https://upload.wikimedia.org/wikipedia/commons/";
    private static final String BACKGROUND = "0/0e/Farol_-_Prieto_Coussent.jpg";
    private static final String[] BTN_PATHS = {
            "thumb/0/09/HanDev.jpg/100px-HanDev.jpg",
            "thumb/3/3f/SugababesInEntirety.png/100px-SugababesInEntirety.png",
            "thumb/c/c5/GeorgesDanton.jpg/100px-GeorgesDanton.jpg",
            "thumb/5/54/Written_on_the_wind8.jpg/100px-Written_on_the_wind8.jpg",
            "thumb/6/6d/COP_20000_anverso_%281996-2016%29.jpg/100px-COP_20000_anverso_%281996-2016%29.jpg"
    };
    private Image background = null;

    public ClientPanel() throws IOException {
        URL imgUrl = new URL(COMMON + BACKGROUND);
        background = ImageIO.read(imgUrl);

        JPanel btnPanel = new JPanel(new GridLayout(1, 0, 15, 0));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        btnPanel.setOpaque(false);
        for (String btnPath : BTN_PATHS) {
            String imgPath = COMMON + btnPath;
            imgUrl = new URL(imgPath);
            Image img = ImageIO.read(imgUrl);
            Icon icon = new ImageIcon(img);
            JButton btn = new JButton(icon);
            JPanel wrapperPanel = new JPanel();
            wrapperPanel.setOpaque(false);
            wrapperPanel.add(btn);
            btnPanel.add(wrapperPanel);
        }
        setLayout(new BorderLayout());
        add(btnPanel, BorderLayout.PAGE_END);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet() || background == null) {
            return super.getPreferredSize();
        }
        int prefW = background.getWidth(this);
        int prefH = background.getHeight(this);
        return new Dimension(prefW, prefH);
    }


    private static void createAndShowGui() {
        ClientPanel mainPanel = null;
        try {
            mainPanel = new ClientPanel();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        JFrame frame = new JFrame("Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}