try {
    int number = Integer.parseInt(yourString);

} catch (NumberFormatException ex) {
    System.out.println("Not a valid number!");
}