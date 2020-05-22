double balance = readDouble("Enter your balance here: ");
double intrest = readDouble("Enter your intrest rate here: ");
double yearsIntrest = (balance / 100) * intrest;
balance += yearsIntrest;
println("The balance after a year would be £" + balance +".");

// Now the interest must be recomputed, since the balance has changed:
yearsIntrest = (balance / 100) * intrest;

balance += yearsIntrest;
println("The balance after two years would be £" + balance +".");