System.out.println("Welcome to Grocery List ! \n");
System.out.print("Enter the total number of items you want to buy (not total units !) : ");
totalItems = NumItems.nextInt();
System.out.println();

unitPrice1 = new double[totalItems];
itemName1 = new String[totalItems];
totalUnits1 = new int[totalItems];