String[]favoriteCities = new String[scanner.nextInt()]; //read int

    //consume line end, and do nothing with it
    scanner.nextLine();
    //now read the cities.
    for(int i=0;i<favoriteCities.length;i++){
        favoriteCities[i]=scanner.nextLine();

    }