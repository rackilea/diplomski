rule "interface"
when
    Line( $n1: number, $tok: tokens contains "interface" )
    Line( number == $n1 + 1, tokens not contains "disabled" )
    Line( number == $n1 + 2,
       tokens not contains "parameter" ||
       tokens contains "parameter" && $tok.indexOf( "parameter" ) < $tok.size() - 1 )
then
    insert( new Error( $n1, "interface configuration error" ) );
end