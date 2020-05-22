double adultBill = (Adult * 10.50) - (freeAdult * 10.50);
double childBill = Child * 7.30;
double concessionsBill = concessions * 8.40;
double totalBill = adultBill + childBill + concessionsBill;
double totalBill2 = childBill + concessionsBill;
System.out.println(totalBill2); //reference out
if (freeAdult >= Adult) {
    System.out.printf("Total bill is: £%.2f\n", totalBill);
} else if (freeAdult < Adult) {
    System.out.printf("Total bill is: £%.2f\n", totalBill2);
} else {
    System.out.println("Please enter a corrrect value");
}