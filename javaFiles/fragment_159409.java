public String trim(String s) {

   String result = s.trim(); 
   String x = result.replaceAll("<br>", "");
   x = x.replaceAll("&nbsp", "");
   x = x.trim();
   if(x.equals("")) {
       return x;
   } else {
       return result;
   }
}