public static void main(String[] args)
  {
    String s = "123 4545>abc5  >4545454 45454 45 44555< 454545";
    String[] tokens = s.split("<|>");
    for(String t : tokens)
      System.out.println(t);
  }