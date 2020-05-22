public class RainbowTest {
   public static void main(String[] args) {
      Set<Color> rainbow = new HashSet<>();
      rainbow.add(new Red(.1f));
      rainbow.add(new Blue(.1f));
      rainbow.add(new Green(.1f));
      System.out.println(rainbow.contains(new Blue(.5f)));
      System.out.println(rainbow.contains(new Red(.1f)));
   }
}

abstract class Color {
   private final float intensity;

   public Color(float intensity) {
      this.intensity = intensity;
   }

   public float getIntensity() {
      return intensity;
   }

   @Override
   public int hashCode() {
      int hash = 3;
      hash = 83 * hash + Float.floatToIntBits(this.intensity);
      return hash;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      final Color other = (Color) obj;
      if( this.intensity != other.intensity )
         return false;
      return true;
   }

}

class Red extends Color {

   public Red( float intensity ) {
      super( intensity );
   }

}
class Green extends Color {

   public Green( float intensity ) {
      super( intensity );
   }

}
class Blue extends Color {

   public Blue( float intensity ) {
      super( intensity );
   }

}