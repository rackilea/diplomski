System.out.println("What would you like to add to the list?");
String input = scan.nextLine();
while(!input.equals("STOP"))
{
    list.add(input);
    input = scan.nextLine();
}