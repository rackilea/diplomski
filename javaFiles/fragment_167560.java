public String concatenateStrings2(String[] strings){
  StringBuffer sb = new StringBuffer();
  for( int i = 0; i < strings.length; i++ )
    sb.append( strings[i] );

  return sb.toString();
}