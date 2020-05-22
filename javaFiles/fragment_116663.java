public class TestNumber{
  public static void main(String[] args){
    byte b1 = -60;
    int b2 = b1 & 0xFF;
    System.out.println("Without casting "+ b1);
    System.out.println("With casting "+b2);
    System.out.println("Bitwise Trickery " + (b1 & 0xFF));
  }
}