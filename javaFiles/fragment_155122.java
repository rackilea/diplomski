Mainemenu menu = null;

while ((record = br.readLine()) !=null) {

    // Split line by a whitespace character
    // split[0] <- username
    // split[1] <- password
    String[] split = record.split("\\s");

    if (user.equals(split[0]) && pass.equals(split[1])) {

        menu = new Mainemenu();
        menu.AdminMenu();

        // You found the user, exit the loop
        break;
    }

    // Delete else branch

}

if (menu == null) {
    // User not found
}