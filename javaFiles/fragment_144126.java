public class InstanceofTest {
  public static void main(String[] args){
      W w = new W();

      if (w instanceof I1)
        System.out.println("W implements I1");

      if (w instanceof I2)
        System.out.println("W implements I2");

      if (w instanceof I3)
        System.out.println("W implements I3");

      if (w instanceof I4)
        System.out.println("W implements I4");

      if (w instanceof X)
        System.out.println("W extends X");
    }
}