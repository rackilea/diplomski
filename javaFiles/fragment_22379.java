private static String getString( byte[] bytes ) 
{
  StringBuffer sb = new StringBuffer();
  for( int i=0; i<bytes.length; i++ )     
  {
     byte b = bytes[ i ];
     String hex = Integer.toHexString((int) 0x00FF & b);
     if (hex.length() == 1) 
     {
        sb.append("0");
     }
     sb.append( hex );
  }
  return sb.toString();
}