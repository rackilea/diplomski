Scanner sc = new Scanner(System.in);

System.out.print("Please enter your distance (miles): ");
String distanceInMiles = Double.parseDouble(sc.nextLine());
System.out.println("The distance (miles): " + distanceInMiles);

System.out.print("Please enter vehicle's fuel efficiency (mpg): ");
String fuelEfficiency = Double.parseDouble(sc.nextLine());
System.out.println("Fuel efficiency (mpg):" + fuelEfficiency);

System.out.print("Please enter the price per gallon (dollars): ");
String pricePerGallon = Double.parseDouble(sc.nextLine());
System.out.println("Price per gallon (dollars): " + pricePerGallon);

double tripCost = (distanceInMiles / fuelEfficiency) * pricePerGallon;
System.out.println("The trip cost (dollars): " + tripCost);