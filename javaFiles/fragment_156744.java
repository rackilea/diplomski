final TreeMap<BigDecimal, BigDecimal> rates = new TreeMap<BigDecimal, BigDecimal>();
rates.put(new BigDecimal(0), new BigDecimal(0.01));
rates.put(new BigDecimal(5), new BigDecimal(0.02));
rates.put(new BigDecimal(10), new BigDecimal(0.04));
rates.put(new BigDecimal(20), new BigDecimal(0.09));

System.out.println(rates.floorEntry(new BigDecimal(0)).getValue());
System.out.println(rates.floorEntry(new BigDecimal(6)).getValue());
System.out.println(rates.floorEntry(new BigDecimal(10)).getValue());
System.out.println(rates.floorEntry(new BigDecimal(100)).getValue());