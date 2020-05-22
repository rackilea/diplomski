double d = 4242424.5242;
DecimalFormatSymbols dfs = new DecimalFormatSymbols();
dfs.setDecimalSeparator('@');
dfs.setGroupingSeparator(' ');
DecimalFormat df = new DecimalFormat("######.00000", dfs);
df.setGroupingUsed(true);
df.setGroupingSize(3); // set explicitely the grouping to 3
System.out.println(df.format(d)); // prints the expected 4 242 424@52420