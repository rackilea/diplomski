DateFormatSymbols sym = new DateFormatSymbols(Locale.US);
sym.setAmPmStrings(new String[] { "AM", "PM"});
SimpleDateFormat sdfBefore = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a", sym);

System.out.println("Debug: test6 = "+sdfBefore.format(System.currentTimeMillis()));
System.out.println("Debug: test9 = "+sdfBefore.parse("05/26/2014 06:57:09 AM"));