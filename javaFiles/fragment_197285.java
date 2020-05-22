DecimalFormat df = new DecimalFormat("#.#");

df.setRoundingMode(RoundingMode.HALF_UP);

BigDecimal bd = new BigDecimal(0.15);
System.out.println("bd=" + bd);
System.out.println(df.format(0.15)); // expecting 0.1, getting 0.1
bd = new BigDecimal(0.05);
System.out.println("bd=" + bd);
System.out.println(df.format(0.05));
bd = new BigDecimal(0.06);
System.out.println("bd=" + bd);
System.out.println(df.format(0.06));