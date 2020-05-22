public String createFileContent( List<String> variableNames ) {
  StringBuffer buffer = new StringBuffer();
  for( String name : variableNames ) {
    buffer.append( "Example " ); 
    buffer.append( name ); 
    buffer.append( " = new Example();" ); 
    buffer.append("\n");
  }
  return buffer.toString();
}