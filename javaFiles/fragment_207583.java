int i = 1;
    while(in.hasNext())
    {
        System.out.println("line: " + i++);
        String customerID = in.next();
        String surname = in.next();
        String firstName = in.next();
        String productName = in.next();
        double price = in.nextDouble();
        System.out.println("Price: " + price);
        double quantity = in.nextDouble();
    }