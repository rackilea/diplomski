String cheapAddOns = "Mushrooms, Tomato, ...";
int cheapPrices = 2;

System.out.println("Please enter first AddOns(Mushrooms , Tomato , Corn, Olives): ");
String cheap = s.next();
int price = pizzaPrice;
if ( cheapAddOns.indexOf(cheap) >= 0 ) {
   price += cheapPrice;
}