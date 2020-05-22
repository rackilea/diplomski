System.out.println("Enter your zip code number: ");
    String code = input.next();
    char zipCode = code.charAt(0);

        switch (zipCode) {
        case '0': case '2': case '3':
            System.out.println(code + " is on the East Coast.");
            break;
        /**/
        default:
            System.out.println(code + " is an invalid ZIP Code.");
        }