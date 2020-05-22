double number = 25000.5;
    DecimalFormat df;

    if(number%1==0)
         df = new DecimalFormat("##,###");
    else
        df = new DecimalFormat("##,###.00");

    System.out.println(df.format(number));