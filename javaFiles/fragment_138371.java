import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Photo extends JPanel{

    private static final long serialVersionUID = 1L;
    private String title;
    private ImageIcon image;
    private String description;

    private JLabel titleLabel;
    private JLabel imageLabel;
    private JLabel descLabel;

    public Photo(String title, ImageIcon image, String description) {
        setLayout(new BorderLayout(5,5));
        //
        setBorder(BorderFactory.createLoweredSoftBevelBorder());
        //
        this.title = title; 
        this.titleLabel = new JLabel(title);
        Font f = this.titleLabel.getFont();
        f = f.deriveFont(Font.BOLD);
        f = f.deriveFont(18f);
        this.titleLabel.setFont(f);
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(titleLabel, BorderLayout.CENTER);
        this.add(northPanel, BorderLayout.NORTH);
        //
        this.image = image;
        this.imageLabel = new JLabel(image);
        this.add(imageLabel, BorderLayout.CENTER);
        //
        this.description = description;
        this.descLabel = new JLabel(description);
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(descLabel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        repaint();
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
        repaint();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        repaint();
    }
}