try {
  Integer.parseInt(text); 
  return true; 
 } catch (NumberFormatException e) {
 return false;
 }