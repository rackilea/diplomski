Scanner input = new Scanner(System.in);
String wesker = input.nextLine();
String letter = wesker.substring(0,1);

if(letter.equalsIgnoreCase("y") || letter.equalsIgnoreCase("n")){
    System.out.println("Game start");
} else {
    System.out.println("Game over");
}