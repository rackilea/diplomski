double totalbalance = balance;
do {
    double intbalance = (totalbalance / 100) * interest;
    totalbalance += intbalance;
    years++;
    System.out.println("your balance after " + years +" years = " + totalbalance);
} while(totalbalance <= requiredBal);
System.out.println("it will take" + years + " years to get to " + requiredBal);