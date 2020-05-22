DecimalFormat df = new DecimalFormat();
   DecimalFormatSymbols symbols = new DecimalFormatSymbols();
   symbols.setDecimalSeparator('.');
   df.setDecimalFormatSymbols(symbols);
   Number n = df.parse(str);

   System.out.println(Double.parseDouble(str)+"\t"+str);

   if(n.intValue()==n.doubleValue()){
       System.out.println("This input is of type Integer.");
   }else{
       System.out.println("This input is of type Float.");
   }