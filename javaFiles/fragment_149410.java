Scanner scan = new Scanner(System.in);
String s = scan.nextLine();

try{
    Integer.parseInt(s);
}
catch(NumberFormatException ex){
    System.out.println("Its not a valid Integer");
}