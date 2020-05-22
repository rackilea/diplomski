final String format = "00000.0000000000000000";
DecimalFormat formatter = new DecimalFormat(format);
System.out.println(formatter.format(1.0));
System.out.println(formatter.format(2.345));
System.out.println(formatter.format(10.0));
System.out.println(formatter.format(1243.5678));