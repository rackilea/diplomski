double a = 0.1;
double c = 0.3;

System.out.println(a + " is actually " + new BigDecimal(a));
System.out.println(c + " is actually " + new BigDecimal(c));
double a3 = a * 3;
System.out.println("0.1 * 3 or " + a3 + " is actually " + new BigDecimal(a3));
double ac = a + c;
System.out.println("0.1 + 0.3 or " + ac + " is actually " + new BigDecimal(ac));