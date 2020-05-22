@Override
public void actionPerformed(ActionEvent e) { // Called by Timer.
    imageSource.newPixels(imageData, models.peek(), 0, N);
    models.add(models.remove());
    repaint();
}