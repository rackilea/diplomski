public class CustomButton extends JButton{
public CustomButton(String buttonText,int sizeX, int sizeY,int locationX, int locationY)  {
    super(buttonText);
    this.setSize(sizeX, sizeY);
    this.setLocation(locationX, locationY);
}