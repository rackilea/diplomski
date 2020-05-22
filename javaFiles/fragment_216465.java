Scanner scnr = new Scanner(System.in);
Random rand = new Random();

System.out.println("Welcome to the coin flip analyzer.");

System.out.print("How many flips? ");
int flips = scnr.nextInt();

String previousResult = null;
String result;
for (int i = 0; i < flips; ++i) {
    result = rand.nextInt(2) == 0 ? "H" : "T";
    System.out.print(!result.equals(previousResult) ? " " + result : result);   
    previousResult = result;
}