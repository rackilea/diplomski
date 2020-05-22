public static void main(String[] args) {
    final int DIV = 24;
    int variable;
    int counter = 1;
    {
      // *a*
      variable = counter++;
      int y = 12;
      variable += y;
      counter++;
      // *b*
      System.out.println("y: " + y);            //  just an example

    }
    final double d;
    {
      counter = 4;
      double a = 10.0;
      {
        d = a + ++counter;
        // c
        System.out.println("d: " + d);             //  just an example

      }
      counter = 3;
      while (counter > 0) {
        counter--;
        a -= counter;
        // *d*
        System.out.println("a: " + a);                   //  just an example
      }
    }
    variable = variable / DIV;
    // *e*

    System.out.println("variable: " + variable);            //  just an example
    System.out.println("DIV: " + DIV);
    System.out.println("d: " + d);
    System.out.println("counter : " + counter);
}