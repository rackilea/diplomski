void salesData() throws IOException {
    for (int srIndex = 0; srIndex < 100; srIndex++)
    {
        System.out.print("Enter Name: ");
        n = stdin.readLine();
        name[srIndex] = n;
        System.out.print("Enter Year to Date Sales: ");
        y = Double.parseDouble(stdin.readLine());
        ytd[srIndex] = y;
        totYtd = totYtd + y;
        System.out.print("Enter Transaction Number: ");
        t = Integer.parseInt(stdin.readLine());
        if (t == 0) {
            break;
        } else {
            tNum[srIndex] = t;
        }
        System.out.print("Enter Transaction Type: ");
        tp = stdin.readLine();
        type[srIndex] = tp;
        System.out.print("Enter Transaction Amount: ");
        a = Double.parseDouble(stdin.readLine());
        totSales = totSales + a;
        totYtd = totYtd + a;
        empTotal = empTotal + a;
        empBonus = empBonus + (a * 0.05);

        calcSalesData();
        outputSalesData();
        //ask to enter another sales report
        System.out.print("Do you want to enter another Sales Report? (yes)");
        String userInput = stdin.readLine();
        if(!userInput.equalsIgnoreCase("yes"))
            break;
        }
}