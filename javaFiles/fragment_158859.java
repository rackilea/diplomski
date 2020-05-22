while (fileInput.hasNext())
    {
        String symbol = fileInput.next();
        if (fileInput.hasNextInt () == false) {
            System.err.println ("File Format Error - expecting an int");
            break;
        }    
        int quantity = fileInput.nextInt();
        Stock myStock = new Stock(symbol);
        double total = myStock.getPrice() * quantity;
        String aFormatCounter = new DecimalFormat("00000").format(count);
        if (myStock.getName() == null) {
            output.println(aFormatCounter + " Symbol " + symbol + " does not exist!");
        }
        else {
            output.printf("%s %.2f%n", aFormatCounter, myStock.getPrice());
        }
        totalValue += total;
        count = count + 2;
    }