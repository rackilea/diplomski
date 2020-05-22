rowIndex = 1;
    for (int j = 0; j < regions.length; j++) // here regions.length
    {
        int sum = 0;
        for (int i = 0; i < regions[j].length; i++) // here index j
        {
            sum += regions[j][i];
        }
        System.out.println("Q" + rowIndex + ": " + currency.format(sum));
        rowIndex++;
    }