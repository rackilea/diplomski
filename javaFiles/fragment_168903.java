BigInteger total = BigInteger.ZERO;
for (Date date : dates) {
     total = total.add(BigInteger.valueOf(date.getTime()));
}
BigInteger averageMillis = total.divide(BigInteger.valueOf(dates.size()));
Date averageDate = new Date(averageMillis.longValue());