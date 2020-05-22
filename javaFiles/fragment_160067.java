public class Test {
  public static void main(String[] args) {
    int counter = 0;
    Scanner scanner = new Scanner(System.in);
    List<Integer> values = new ArrayList<>();

    while (counter < 5) {
      System.out.print("Enter integer (" + (counter + 1) + "): ");
      int value = scanner.nextInt();

      if (value >= 1 && value <= 200) {
        counter++;
        values.add(value);
      } else {
        System.out.println("Please enter a value between 1 and 200");
      }
  }
  System.out.println("Between 1-50   : " + values.stream().filter(val -> val < 50).count());
  System.out.println("Between 50-100 : " + values.stream().filter(val -> val >= 50 && val <= 100).count());
  System.out.println("Between 101-150: " + values.stream().filter(val -> val > 100 && val <= 150).count());
  System.out.println("Between 151-200: " + values.stream().filter(val -> val > 150 && val <= 200).count());
}