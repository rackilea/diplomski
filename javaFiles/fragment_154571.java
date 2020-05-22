String letter = "";
do{
  System.out.println("Enter a temperature in degrees (for example 32.6): ");
  double temp = 0;
  while(true){
      if(keyboard.hasNextDouble())
      {
          temp = keyboard.nextDouble();
          break;
      }
      else
      {
          System.out.println("Enter a valid double");
          sc.nextLine();
      }
  }
  System.out.println("Enter 'F' (or 'f') for Fahrenheit or 'C' (or 'c') for Celsius: ");
  letter = keyboard.next();
  double total = 0;
  //if Farenheit then do this equation
  if (letter.equalsIgnoreCase("F"))
  {
      total = ((temp-32)*5)/9; //convert the entered temperature to Celsius
      System.out.println(temp + " degrees F = " + total + " degrees Celsius");
  }
  else if (letter.equalsIgnoreCase("C"))
  {   //if Celsius then do this
      total = (((temp*9))/5)+32; //convert the entered temperature to Farenheit
      System.out.println(temp + " degrees C = " + total + " degrees Fahrenheit");
  }
}while(!letter.equalsIgnoreCase("Q"));