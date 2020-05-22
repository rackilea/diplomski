String text = ...;
  String[] paras = text.split( "(?<=(^|\\n))\\(\\d+\\)" );
  for( String para: paras ){
      if( para.length() > 0 ){
          System.out.println( "Para: " + para );
      }
  }