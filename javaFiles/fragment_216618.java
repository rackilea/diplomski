boolean isBig(String text) {
  System.out.println(text);
  return text.length() > 10;
}

...
if( isBig(string1) || isBig(string2) ){
   ...
}