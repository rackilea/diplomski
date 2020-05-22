public class Split {
public static void main(String[] args) {
    String line = "COD Amount = 333.98";
    String[] array = line.split("=");
    double amount = Double.parseDouble(array[1]);
    System.out.println(amount);
}
}