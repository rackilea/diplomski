private double scale = 0.75;

@override
public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D)g; // The newer more ellaborate child class.
    g2.scale(scale, scale);
    ...
    g2.scale(1/scale, 1/scale);
}