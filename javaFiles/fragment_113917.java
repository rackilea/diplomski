System.out.println("Please enter your first name");
String firstname = scanner.nextLine(); // Read the first name 
while (!firstname.matches("[a-zA-Z]+")) { // Check if it has anything other than alphabets
    System.out.println("This is not in letters only");
    firstname = scanner.nextLine(); // if not, ask the user to enter new first name
}
int a = firstname.charAt(0); // once done, use this as you wish