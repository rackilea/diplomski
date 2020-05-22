Scanner keyboard = new Scanner (System.in);

Car a = new Car();
System.out.println("Enter you car Brand Name: ");
a.brandName = keyboard.next();
System.out.println("Enter your car color: ");
a.color = keyboard.next();
System.out.println("Enter your new price: ");
a.priceNew = keyboard.nextDouble();
System.out.println("Enter your Odometer:");
a.updateMilage();
System.out.println();
//UPDATE THE USED PRICE 
a.getPriceAfterUse();

a.outputDetails();
System.out.println();