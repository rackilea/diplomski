while(loopcheck.equals("1")) {
    System.out.println("Press 1 to enter a new stock or press 2 to find the LIFO and FIFO dollar cost average for the number of shares sold");
    input = in.next();
    in.nextLine();
    if(input.equals("1")) {
        System.out.println("Enter the stock symbol:");
        symbol = in.nextLine();