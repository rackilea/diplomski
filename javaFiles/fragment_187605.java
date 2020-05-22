DecimalFormat df = new DecimalFormat("$#,###.0"); //set MIN and MAX fraction digits to 1
df.setRoundingMode(RoundingMode.HALF_UP);         //default but showing usage if needed

System.out.println(df.format(123454.84d));
System.out.println(df.format(123454.85d));
System.out.printf("$%,.1f", 123454.85d);          //HALF UP rounding the only option