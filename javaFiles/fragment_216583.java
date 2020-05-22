if (car1SportsModel(acc))
{
    sportsModel = sportsModel + 5000;
    priceTotal = basicPrice + sportsModel;
}
else if (car2SportsModel(acc))
{
    sportsModel = sportsModel + 5000;
    discount = discount - 500;
    priceTotal = basicPrice + carPaints + sportsModel + discount;
}