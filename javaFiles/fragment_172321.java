boolean found = false;
for (int j = 0 ; !found && j != codes.length ; j++) {
    if (userCode[i].equalsIgnoreCase(codes[j])) {
        userScrewyPrice += userQuantity[i]*pricesAndTax[j];
        found = true;
    }
}
if (!found) {
    i--;
}