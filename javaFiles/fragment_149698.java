while (quit == 'Y') {

        System.out.print("Please use underscores instead of spaces e.g. real_big_boats.\n");
        System.out.print("Amount: ");
        amount = scan.nextDouble();
        scan.nextLine() ;

        System.out.print("Unit: ");
        unit = scan.next();
        scan.nextLine() ;

        System.out.print("Ingredient: ");
        ingredient = scan.findInLine("(\\s|\\S)*");
        scan.nextLine() ;

        System.out.print("Tags (e.g. tag;tag;tag): ");
        tags = scan.next();
        scan.nextLine() ;

        list.add(new Ingredients(amount, unit, ingredient, tags));

        System.out.print("More Ingredients? (Y/N) ");
        String s = scan.next();
        scan.nextLine() ;
        s = s.toUpperCase();
        quit = s.charAt(0);
    }