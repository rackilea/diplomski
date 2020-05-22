if (scanner.hasNextLine()) {            // Check for the line.
    scanner.nextLine();                 // read the line.
    if (scanner.hasNext("Account")) {   // Check for account.
        scanner.next("Account");        // read the field.
        if (scanner.hasNext()) {        // Check if there is more.
            String pp = scanner.next(); // read it.
            if (pp.startsWith(";")) {   // remove a leading ';'
                pp = pp.substring(1);
            }
            long lpp = Long.parseLong(pp);  // convert to long.
            System.out.println(lpp);        // print it.
        }
    }
}