Image smallerImage = null;
ImageIcon smallerImageIcon = null;
public void resizeImage(int width, int height, String image)

{
    ImageIcon originalImage = new ImageIcon(image);
    smallerImage = originalImage.getImage().getScaledInstance(width,height,0);
    smallerImageIcon = new ImageIcon(smallerImage);
}