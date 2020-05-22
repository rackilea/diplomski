NumberFormat numberFormat = NumberFormat.getInstance();

    // setting number of decimal places
    numberFormat.setMinimumFractionDigits(2);
    numberFormat.setMaximumFractionDigits(2);

    // you can also define the length of integer
    // that is the count of digits before the decimal point
    numberFormat.setMinimumIntegerDigits(1);
    numberFormat.setMaximumIntegerDigits(10);

    // if you want the number format to have commas
    // to separate the decimals the set as true
    numberFormat.setGroupingUsed(true);

    // convert from integer to String
    String formattedNr = numberFormat.format(12345678L);
    // note that the output will have 00 in decimal place


    // convert from decimal to String
    numberFormat.format(12345.671D);

    // format a String to number
    Number n1 = null;
    Number n2 = null;

      n1 = numberFormat.parse("1,234");
      n2 = numberFormat.parse("1.234");

    // show percentage
    numberFormat = NumberFormat.getPercentInstance();
    numberFormat.format(0.98);
    // answer will be 98%