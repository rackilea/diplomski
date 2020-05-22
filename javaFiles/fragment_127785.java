import java.util.ArrayList;
public class TwoD {
  public void example1() {
    Number[][] table = new Number[10][10];
    table[0][0] = 0;
    table[0][1] = 10;
    table[1][0] = 20;
    table[1][1] = 30;

    System.out.println("\nExample 1");
    System.out.println("Value=" + table[1][0]);
  }

  public void example2() {
    Number[][] table = { { 0, 10 }, { 20, 30 } };

    System.out.println("\nExample 2");
    System.out.println("Value=" + table[1][0]);
  }

  public void example3() {
    ArrayList<ArrayList<Number>> table = new ArrayList<>();
    table.add(new ArrayList<>());
    table.add(new ArrayList<>());
    table.get(0).add(0);
    table.get(0).add(10);
    table.get(1).add(20);
    table.get(1).add(30);

    System.out.println("\nExample 3");
    System.out.println("Value=" + table.get(1).get(0));
  }

  public static void main(String[] args) {
    TwoD me = new TwoD();
    me.example1();
    me.example2();
    me.example3();
  }
}