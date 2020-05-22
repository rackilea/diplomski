@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Draw the FULL image, which, regardless of its size (!) 
    // is here painted to just fill this component:
    g.drawImage(fullImage, 0, 0, getWidth(), getHeight(), null);
}