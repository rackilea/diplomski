while(input.hasNextLine()){

     String cityName = input.next();
     double latitude = input.nextDouble();
     double longitude = input.nextDouble();
     Locations loc = new Locations(cityName, latitude, longitude);

     System.out.println(loc); // automatically calls Locations's toString method
}