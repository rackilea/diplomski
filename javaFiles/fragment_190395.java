if((response.equalsIgnoreCase("y")))
{
    System.out.print("Please enter an item price, or -1 to exit: $");
    double values = numberReader.nextDouble();
    while ((values > (-1)))
    {
        cartItems.add(values);
        System.out.print("Please enter another item price, or -1 to exit: $");
        values = numberReader.nextDouble(); 
    }
 }
 System.out.println();
 System.out.println("********** Here are your items **********");
 System.out.println();
 for (counter = 0; counter < cartItems.size(); counter++){
      System.out.println("Item #" + (counter + 1) + ": " + cartItems.get(counter));
 }
 System.out.println();
 System.out.println("********** Thank you for using the shopping cart **********");