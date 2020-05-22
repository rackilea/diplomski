Scanner kb = new Scanner(System.in);
String b;
System.out.println("Choose a number 1-10.");
int a = 0;
try {
    a = Integer.parseInt(kb.nextLine());
} catch (NumberFormatException numberFormatException) {
    a=0;
}
a = a * 2;
a = a + 5;
a = a * 50;
System.out.println("Enter the year you were born in.");
int c = 0;
try {
    c = Integer.parseInt(kb.nextLine()); //consumes the new line character
} catch (NumberFormatException numberFormatException) {
    c=0;
}
System.out.println("Did you already have your birthday this year?");
b = kb.nextLine();
if (b.equals("yes")) {
    a = a + 1764;
} else {
    a = a + 1763;
}
a = a - c;
System.out.println(a);
kb.close();