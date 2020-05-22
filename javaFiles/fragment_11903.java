if (rt.detalization.equals("week")) {  
       DateTimeFormat format2 = DateTimeFormat.getFormat("E");
    String day= format2.format(dtfDate);              
         System.out.println(day+"-Sun");

}