private Pattern s_hexPattern = Pattern.compile("_x([A-Fa-f0-9]{4})_"); 
  public String convertHexToString ( String str ) {

    Matcher m = s_hexPattern.matcher(str);
    while ( m.find() ){
        int decimal = Integer.parseInt(m.group(1), 16);
        str = str.replace(m.group() , (char)decimal + "" ) ;
    }

    return str;
    }