private int showMenuAndGetUserChoice() {
 // create a menu and display it to the user
 // then ask the user to choose an option
 String menu = "1) See Rules\n" ...
 String userChoice = JOptionPane.showInputDialog(menu);
 JOptionPane.showMessageDialog(null, "You chose option " + userChoice); ...

 return Integer.parseInt(userChoice);
}