int priceSell = 10;
int priceBuy = 5;
if (Math.abs(priceSell-priceBuy)>(priceSell/10))
    System.out.println("the price isn't within 10%");
else
    System.out.println("the price is within 10%");