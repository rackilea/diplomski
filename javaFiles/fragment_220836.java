String amountString = String.format("%,.2f", amt);

    if (amt < 0){
        amountString = amountString.substring(1, amountString.length());
        amountString = "(" + amountString + ")";
    }
    else if(amountString.length() < width){
        amountString = amountString + " ";
    }

    while(amountString.length() < width)
    {
        amountString = " " + amountString;
    }

    System.out.println("{" + amountString + "}");