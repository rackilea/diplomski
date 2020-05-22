public boolean compareCSAndString(CharSequence cs, String string) {
  if(cs == null) {
    // If both are null, then they're equal
    return string == null; 
  }
  else {
    return cs.toString().equalsIgnoreCase(string);
  }
}