Scanner scnr = new Scanner(System.in);
int num = -1;
String s;
do {
    System.out.println("Enter a number (int): ");
    s = scnr.next().trim(); // trim so that numbers with whitespace are valid

    if (s.matches("\\d+")) { // if the string contains only numbers 0-9
        num = Integer.parseInt(s);
    }
} while(num < 0 || !scnr.hasNextLine());