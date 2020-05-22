public class MyImageIcon extends ImageIcon{
   String imageColor;
   // Getters and setters...  
   // Appropriate constructor here.
   MyImageIcon(Image image, String description, String color){
       super(image, description);
       imageColor = color;
   }
   @Override
   public bool equals(Object other){
      MyImageIcon otherImage = (MyImageIcon) other;
      if (other == null) return false;
      return imageColor == other.imageColor;
   }
}