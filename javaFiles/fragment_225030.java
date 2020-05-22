String s = "128166947252913248";
DecimalFormat df = new DecimalFormat(
        "##########################.########");
BigDecimal oldTime1 = new BigDecimal(s);
BigDecimal oldTime2 = new BigDecimal("128166947252913249");
BigDecimal oldTime3 = new BigDecimal("128166947252913247");
BigDecimal newTime = new BigDecimal("116444736000000000");
System.out.println(newTime.longValue());
System.out.println(df.format(oldTime1));
System.out.println(oldTime1.subtract(newTime));
System.out.println(df.format(oldTime1.subtract(newTime)));
System.out.println(df.format(oldTime3.subtract(newTime)));