Scanner userInputScanner = new Scanner(System.in);
String s = userInputScanner.nextLine();

try{
    Integer.parseInt(s);
}
catch(NumberFormatException ex){
    System.out.println("Its not a valid Integer");
}