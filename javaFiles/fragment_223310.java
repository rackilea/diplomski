final Pattern pattern = Pattern.compile(<<Regular Expression Here>>);
int userInput;
String userString;
Scanner scan = new Scanner(System.in);
while(true) {
    userString = scan.nextLine();
    if (pattern.matcher(userString).matches()) {
        break;
    } else {
        System.out.println("Input invalid. Try again!");
    }
}
userInput = Integer.parseInt(userString);