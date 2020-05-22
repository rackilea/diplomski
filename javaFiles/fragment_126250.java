Scanner sc = new Scanner(System.in);
int sum = 0;
String input;
do {
    System.out.println("Enter Num");
    input = sc.next();
    if (input.matches("\\d+")) { // <-- sanity check for digits.
        try {
            sum += Integer.parseInt(input);
        } catch (Exception ignored) {
        }
    }
} while (!input.equals("="));
System.out.println(sum);