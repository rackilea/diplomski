public class k {

  public static void main(String argv[]) {
    String number = "1.0E7";
    Double num = Double.valueOf(number);
    System.out.println("Double="+ num + " Formatted Double=" + String.format("%.4f", num));
  }
}