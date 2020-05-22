String val = "No";
Scanner scan2 = new Scanner(System.in);
do{
    System.out.println("do you wanna play again?[Y/N]");
    val = scan2.next();
}
while(!val.equalsIgnoreCase("Y") && !val.equalsIgnoreCase("N"))
if (val.equalsIgnoreCase("Y")) {
   playGame();
   break;
} else {
   break;
}