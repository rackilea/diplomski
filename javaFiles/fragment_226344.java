package com.whitefang34;

public class ImageIconApplet extends JApplet {
    public void init() {
        URL url = getClass().getResource("/images/WhiteFang34.jpg");
        ImageIcon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon, JLabel.CENTER);
        add(label);
    }
}