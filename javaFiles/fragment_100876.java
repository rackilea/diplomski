String second = keyboard.next();
int loan = 0
if (second.equalsIgnoreCase("yes")) {
  loan = 8000;
} else {
  System.out.println ("how much do you get");
  loan = keyboard.nextInt(); 
}
System.out.println(loan);