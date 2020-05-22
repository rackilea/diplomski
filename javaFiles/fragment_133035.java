System.out.println("where would you like to send the following item: ");
    System.out.println("1. groceries, 2. savings, 3. utilities");
    System.out.print("Enter list name or list number to send: ");
    String user = user_input.nextLine();
    if (user.toLowerCase().equals("groceries") || user.equals("1")) {
        System.out.println("item was sent to the grocery list");

    }else if(user.toLowerCase().equals("savings") || user.equals("2")) {
        System.out.println("item was sent to the savings list");

    }else if(user.toLowerCase().contains("utilities") || user.equals("3")) {
        System.out.println("item was sent to the utilities list");

    }else{
        System.out.println("item is not in any category");

    }