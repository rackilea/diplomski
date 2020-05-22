private void checkPasswordSame() {
    String first = password1.getText();
    String second = password2.getText();
    if (first.equals("") || second.equals("")) {
        System.out.println("Both password can't be empty");
    } else if (!first.equals(second)) {
        System.out.println("Passwords not the same");
    }
    else {
        System.out.println("Passwords same");
    }
}