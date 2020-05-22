String row = "'what','ever'";
Matcher matcher = Pattern.compile("('.*')?,('.*')?").matcher( row );
if( matcher.matches() )
{
  String group1 = matcher.group( 1 );
  String group2 = matcher.group( 2 );
}