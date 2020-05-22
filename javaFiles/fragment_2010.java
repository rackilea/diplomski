String str = "60.00 USD";
int value = 5;
String dollarValue = str.split(" ")[0];
Float price = Float.parseFloat(dollarValue );
Float result = price * value;

DecimalFormat df = new DecimalFormat("#.##");
df.setMinimumFractionDigits(2);
String resultString = df.format(result);