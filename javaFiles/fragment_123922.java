HashSet<Double> hs = new HashSet<Double>();
double x1, x2, x3;

x1 = (double)0/1;
System.out.println(x1 + " "+ hs.add(x1)); //true

x2 = (double)0/2;
System.out.println(x2 + " " + hs.add(x2)); //false

x3 = (double)0/-1;
System.out.println(x3 + " " + hs.add(x3)); //true