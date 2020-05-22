if(option.equalsIgnoreCase("view")) {
    System.out.println("\tADDRESS BOOK" + "\n" +
            "=============================");

    readContact();
    Collections.sort(card);
    printContacts();
}