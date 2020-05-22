public String getRadio() { 
   if(rdValue == null || rdValue.trim().isEmpty()) {
       return "YOUR_DEFAULT_VALUE";
   }

   return rdValue;
}