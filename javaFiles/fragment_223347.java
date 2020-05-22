DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(Locale.FRANCE);
df.setParseBigDecimal(true);
BigDecimal bd = (BigDecimal) df.parseObject(outSum);
BigDecimal bd100 = bd.multiply(BigDecimal.valueOf(100))
                     .setScale(0, RoundingMode.HALF_UP);
long centAmount = bd100.longValue();