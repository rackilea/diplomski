void parse() : { }
{
    ows() body }
}

void body() : { }
{
    part() ( sep() body()  | <EOF> )
}

void part() : { }
{
   <NAME>
|
   <NUM>
   ( LOOKAHEAD( ows() "-")
     ows() "-" ows() <NUM>
   )?
}

void sep() : {}
{
    (<EOL> | <COMMA> | <SEMICOLON> | <WHITE>)+
}

void ows() : {}
{
    (<WHITE>)*
}