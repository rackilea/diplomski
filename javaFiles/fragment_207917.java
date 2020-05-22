biMap.put(0, 0);
System.out.println(biMap); // {0=0}
biMap.put(2, 1);
System.out.println(biMap); // {0=0, 2=1}
final Integer previousValue = biMap.inverse().put(1, 3);
System.out.println(biMap); // {0=0, 3=1}
System.out.println(previousValue); // 2