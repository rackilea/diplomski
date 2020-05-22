System.out.println("where would you like to send the following item: ");
    System.out.println("1. groceries, 2. savings, 3. utilities");
    System.out.print("Enter list name or list number to send: ");
    String user = user_input.nextLine();
    try {
          if (user.toLowerCase().equals("groceries") || Integer.parseInt(user) == 1) {
                 System.out.println("item was sent to the grocery list");

          }else if(user.toLowerCase().equals("savings") || Integer.parseInt(user) == 2) {
                 System.out.println("item was sent to the savings list");

          }else if(user.toLowerCase().contains("utilities") || Integer.parseInt(user) == 3) {
                 System.out.println("item was sent to the utilities list");

          }else{
                 System.out.println("item is not in any category");

          }
    } catch (NumberFormatException nfe) {
        System.out.println("item is not in any category");
    }