String password = input.next().toLowerCase();
String correctPassword = "bolt";

if (password.length() != correctPassword.length()) {
    System.out.println("Not valid");
    return;
}

for (int i = 0; i < correctPassword.length(); i++) {
    if (password.charAt(i) != correctPassword.charAt(i)) {
        System.out.println("Not valid");
        return;
    }
}
System.out.println("Valid");