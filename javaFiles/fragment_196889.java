float amt = 0.0;
int cents, quarter, dime, nickle, penny;

// Get amt from user between 0.0 and 1.0

cents = (int)amt*100;

quarter = cents/25;
cents = cents % 25;

dime = cents/10;
cents = cents % 10;

nickel = cents/5;
cents %= 5;

penny = cents;

// Then print out the numbers of each