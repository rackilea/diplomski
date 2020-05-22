public static void main(String[] args)
{
    String x1 = JOptionPane.showInputDialog(null, "X: ");
    String y1 = JOptionPane.showInputDialog(null, "Y: ");
    double x = Double.parseDouble(x1);
    double y = Double.parseDouble(y1);
    System.out.println("Sum: \t\t" + (x+y));
    System.out.println("Difference: \t" + (x-y));
    System.out.println("Product: \t" + (x*y));
    System.out.println("Average: \t" + (x+y)/2);
    System.out.println("Distance: \t" + Math.abs(x-y));
    System.out.println("Maximum Value: \t" + Math.max(x,y));
    System.out.println("Minimum Value: \t" + Math.min(x,y));
}