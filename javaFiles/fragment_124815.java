public static void main(String[] args)
  {
  double length;
  double width;

  Scanner keyboard = new Scanner(System.in);

  System.out.print("Enter the length >> ");
  length = keyboard.nextDouble();
  System.out.print("Enter the width >> ");
  width = keyboard.nextDouble();
  keyboard.nextLine();

 double area = calculateArea(length, width);
 calculatePrice(area);
 }