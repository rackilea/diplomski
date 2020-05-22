StringBuilder strBuilder = new StringBuilder();
strBuilder.append( name );
strBuilder.append( System.getProperty( "line.separator" ) );
strBuilder.append( addressLine_1 );
/* ... */

System.out.println( strBuilder.toString() );
return strBuilder.toString();