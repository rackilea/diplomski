String oPerson= null;
if (CheckAddress("5556", oPerson)) {
   print(oPerson); // DOESN'T "WORK"! Java passes by value; String is immutable!
}

private boolean CheckAddress(String iAddress, String oPerson) {
   // on search succeeded:
   oPerson = something; // DOESN'T "WORK"!
   return true;
   :
   // on search failed:
   return false;
}