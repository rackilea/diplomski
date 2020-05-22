Unit<Area> sq_km = (Unit<Area>) MetricPrefix.KILO(SI.METRE).multiply(MetricPrefix.KILO(SI.METRE));
System.out.println(a.to(sq_km));
System.out.println(pop.divide(a.to(sq_km)));

Unit<Area> sq_mile = (Unit<Area>) USCustomary.MILE.multiply(USCustomary.MILE);
System.out.println(a.to(sq_mile));
System.out.println(a.to(NonSI.HECTARE));

System.out.println(a.to(USCustomary.ACRE).getValue() + " acres");