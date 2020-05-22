Scanner keyboard = new Scanner(System.in);
 String number = keyboard.nextLine();
 int guess, guess2;
 guess = Integer.valueOf((number.substring(0, 1)));
 guess2 = Integer.valueOf((number.substring(1, 2)));
 System.out.println(guess);
 System.out.println(guess2);