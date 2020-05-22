public String getString(String abc){ // Ex. abc = "address1"

   int resID = getResources().getIdentifier(abc, "string",  getPackageName()); 

   return context.getResources().getString(resID);
}