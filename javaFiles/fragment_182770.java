public static String limit(String value, int length)
  {
    // note to Test this first, so you don't create a Buffer unnecessarily.
    String ret = value;
    if ( value.length() > length ) {
       StringBuilder buf = new StringBuilder(value);
       buf.setLength( length );
       int cur = length;
       while( cur < value.length() && value.charAt(cur) != ' ' ) {
           buf.append( value.charAt(cur) );
       }
       if ( cur == value.length() ) {
          ret = value;  // we copied the whole string, as it turns out.
       } else {
          buf.append( "..." );
          ret = buf.toString();
       }
    }
    return value;
  }