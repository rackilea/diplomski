void DeclOrInput() :
{}
{
     LOOKAHEAD( Input() ) Input()
|
     LocalDeclStatement()
}

void Input() :
{  }
{  <NEW>
   LOOKAHEAD({ token(1).image.equals("Scanner") } )
   <ID> 
   "("
   LOOKAHEAD( { token(1).image.equals("System") } ) 
   <ID> 
   "."
   LOOKAHEAD( { token(1).image.equals("in") } )
   <ID> 
   ")" "."
   LOOKAHEAD( { token(1).image.equals( "nextInt" ) } )
   <ID> 
   "(" ")" ";"
}