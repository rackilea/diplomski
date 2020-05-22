double investment = scanner.nextDouble();
...

for (int year = 0; year < yearsInvested; year++) {
    investment += investment * interestRate;
    System.out.println("Total year " + year + " is " + investment);
}