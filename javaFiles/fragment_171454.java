public static void main(String[] args)
  {
   System.out.println(calculateMidpointX(1.373,3)); // Print 2.19
  }


  public static double calculateMidpointX(double x, double y) { 

    DecimalFormat num = new DecimalFormat("###.##");
    Double xmid = (x + y) / 2.0;
    return (Double.parseDouble(num.format(xmid))); // This return 2.19
  }