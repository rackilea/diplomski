for(int i = 0 ; i < drinkList.length(); i++) {
    if(drinkList[i] instanceof DrinkInBox)
        (DrinkInBox)drinkList[i].computeTotalPrice();
    else if(drinkList[i] instanceof DrinkInCylinder)
        (DrinkInCylinder)drinkList[i].computeTotalPrice();
}