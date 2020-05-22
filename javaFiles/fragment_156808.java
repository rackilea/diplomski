TimeZone utc = TimeZone.getTimeZone("UTC")

SimpleDateFormatter df = new SimpleDateFormatter (PATTERN);
df.setTimeZone(utc);

System.out.println(df.format(date));