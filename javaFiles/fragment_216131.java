//char r
return Integer.parseInt(r +""); //+"" converts 'r' to "r"
//or, as mentioned below
return Character.getNumericValue(r); 
//works for things like roman numerals     
//but also will always return SOME value.
//Be aware of this, because you may not expect to get an int for 'a'