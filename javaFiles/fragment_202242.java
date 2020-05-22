DecimalFormat df = new DecimalFormat("€#,###.#");
DecimalFormatSymbols dfSymbols = new DecimalFormatSymbols();
dfSymbols.setDecimalSeparator(',');
dfSymbols.setGroupingSeparator('.');
df.setDecimalFormatSymbols(dfSymbols);

String str1 = "€12,32123";
String str2 = "€3.452,35";
double str1Ch = df.parse(str1).doubleValue();
double str2Ch = df.parse(str2).doubleValue();

System.out.println(str1Ch);//12.32123
System.out.println(str2Ch);//3452.35