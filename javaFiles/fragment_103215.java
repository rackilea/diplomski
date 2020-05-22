Scanner sc = new Scanner(System.in);
String s = "";
System.out.print("Please enter some Strings: ");
while (true){
    String input = sc.nextLine();
    if(input.equalsIgnoreCase("stop"))
        break;
    s += input + " not ";
}
if (s.length() >= 5)
    s = s.substring(0, s.length() - 5);
System.out.println(s);