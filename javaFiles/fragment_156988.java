public String toString() {

 StringBuilder builder = new StringBuilder();

  for( int i = 0; i < list.length; i++ )
  {
     builder.append(String.format("%d. %s\n", i+1, list[i]));  
  }
  return builder.toString(); 
}