public class MyButton extends JButton
{
   private BufferedImage bufImg;

   public MyButton(BufferedImage bufImg)
   {
      super(new ImageIcon(bufImg));
      this.bufImg = bufImg;
   }
 }