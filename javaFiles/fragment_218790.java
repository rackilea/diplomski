Integer num1 = 0;
  while (num1 != 999) {
     String input1= JOptionPane.showInputDialog("Enter a evan number");
     num1 = Integer.parseInt( input1);

     if ( (num1%2) == 0 ) 
       System.out.println("Good Job!");

    else  {
       System.out.println("HEY thats not evan try again");
    }
}
System.exit(num1);