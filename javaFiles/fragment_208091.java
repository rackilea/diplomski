rule "hostname"
when
  Line( $n: number, $tok: tokens contains "hostname" )
  eval( $tok.get( $tok.indexOf( "hostname" ) + 1 ).length() > 4 ) // incomplete
then
  insert( new Correct( $n, "hostname" ) );
end