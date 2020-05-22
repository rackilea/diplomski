private static House[] getLowPriced(House[] houses, double priceLimit) 
{

    List<House> lowPriceHouses = new ArrayList<House>(houses.length);

    for (int i = 0; i <= houses.length; i++)
    {
        double prices = houses[i].getPrice();
        if (prices <= priceLimit)
            lowPriceHouses.add(houses[i]);
    }

    return lowPriceHouses.toArray(new House[lowPriceHouses.size()]);  
}