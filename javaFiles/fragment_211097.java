Scanner input = new Scanner(System.in);
System.out.print("Please enter a uncoded string: ");
String first = input.nextLine();
input.close();

if (first.charAt(0) == 'u') {
    first = first.toUpperCase();
} else if (first.charAt(0) == 'l') {
    first = first.toLowerCase();
} else if (first.charAt(0) == 'o') {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < first.length(); i = i + 2) {
        sb.append(first.charAt(i));
    }
    first = sb.toString();
} else if (first.charAt(0) == 'e') {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < first.length(); i = i + 2) {
        sb.append(first.charAt(i));
    }
    first = sb.toString();
}
System.out.println("The decoded string is: " + first);