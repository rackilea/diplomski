boolean found = false;
for (i = 0; i < clients.length; i++) {
    if (input.equals(clients[i].accountnumber)) {
        System.out.println("Welcome");
        found = true;
        break;
    }
}