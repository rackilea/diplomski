while(true)
    {
        System.out.print("Enter Transaction Number: ");
        t = Integer.parseInt(stdin.readLine());

        if (t == 0) {
            break;
        }
        else {
            System.out.print("Enter Transaction Type: ");
            tp = stdin.readLine();
            System.out.print("Enter Transaction Amount: ");
            a = Double.parseDouble(stdin.readLine());

            totSales = totSales + a;
            totYtd = totYtd + a;
            empTotal = empTotal + a; 
            empBonus = empBonus + (a * 0.05);

            name[i] = n;
            ytd[i] = y;
            tNum[i] = t;
            type[i] = tp;
            amount[i] = a;

            outputUpdate();

            calcSalesData();
        }
    }