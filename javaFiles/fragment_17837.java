double mantissa_value = 2.11099999;

DecimalFormat df = new DecimalFormat("0.###");
// Un-comment the line below to take English locale into account when converting
//df.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));

// will print '2.11099999' this is what you get in your original case
System.out.println( String.valueOf(mantissa_value) ); 

// will print '2.111' or '2,111' depending on your locale. if you uncomment the line above for English locale it will print '2.111'
System.out.println( df.format(mantissa_value) );