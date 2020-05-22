public static String strReplace(String[] from, String[] to, String s){
  for(int i=0; i<from.length; i++){
    s = s.replaceAll(from[i], to[i]);
  }
  return s;
}