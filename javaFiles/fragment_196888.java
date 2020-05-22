float amt = 0.0;
int cents, quarter, dime, nickle, penny;

// Get amt from user between 0.0 and 1.0

cents = (int)amt*100;

quarter = cents/25;
cents -= quarter*25;

dime = cents/10;
cents -= dime*10;

nickel = cents/5;
cents -= nickel*5;

penny = cents;

// Then print out the numbers of each

/*
if amt = 0.91

cents = 91

quarter = 3
cents = 16

dime = 1
cents = 6

nickel = 1
cents = 1

penny = 1
*/