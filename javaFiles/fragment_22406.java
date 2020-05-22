Object cellContents = ".475";
Number num = null;
if ( cellContents instanceof String ) {
   try {
       double d = Double.valueOf( (String) cellContents );
       num = (Double) d; // Auto-boxing
   }
   catch ( NumberFormatException e ) {
     ...
  }
}
else {
    ...
}