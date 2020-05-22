DecimalFormat df = new DecimalFormat("#.####");
df.setRoundingMode(RoundingMode.CEILING);
for (Number n : Arrays.asList(12, 123.12345, 0.23, 0.1, 2341234.212431324)) {
    Double d = n.doubleValue();
    System.out.println(df.format(d));
}