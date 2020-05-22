ModifierCode m = ModifierCode.fromKeyCode(c); // could throw Exception
doStuff( m );

...

void doStuff( ModifierCode m ) {
   switch ( m ) {
   case ...
}