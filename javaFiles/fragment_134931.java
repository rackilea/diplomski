Scanner mykey= new Scanner (System.in);
  System.out.println("Enter your first sentence");
  String firstSen= mykey.nextLine();
  char firstChar= firstSen.charAt(0); // note this line!
  if ((firstChar <='Z') && (firstChar >= 'A'))
     {System.out.println("Its a letter");}
  else if ((firstChar>='2') && (firstChar<='9'))
     {System.out.println("Its a number");}