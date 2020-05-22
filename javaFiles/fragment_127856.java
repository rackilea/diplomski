double d = 8.03;
BigDecimal bd = new BigDecimal(d);
System.out.println("bd: " + bd);
double d100 = d * 100;
System.out.println("d100: " + d100);
int i100 = (int) d100;
System.out.println("i100: " + i100);
int r100 = (int) Math.round(d100);
System.out.println("r100: " + r100);