try {
   if(originalLocation.matches("s[0-9]{5}"))
      throw new IllegalOriginalLocationException("Original Location is invalid.");
}
catch(IllegalOriginalLocationException ex) {
   System.out.println(ex);
}