List<Integer> a = new ArrayList<Integer>();
a.add(4);
a.add(8);
a.add(91);
a.add(18);
double avgDouble = averageValue(a, doubleAvg);
int avgInt = averageValue(a, intAvg);
System.out.println(avgDouble); // Prints 30.25
System.out.println(avgInt);    // Prints 30