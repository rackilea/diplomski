double d = 815.3100000000001;
System.out.println(d);

DecimalFormat newFormat = new DecimalFormat("#.##");
double twoDecimal =  Double.valueOf(newFormat.format(d));
System.out.println(twoDecimal);