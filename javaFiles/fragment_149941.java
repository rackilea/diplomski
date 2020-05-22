void start() : { Token t ;} {
    (   <A>
    t = <B> { if( seen.contains( t.image ) ) {
                  throw new ParserException( "Duplicate" ) ; }
              else { seen.add( t.image ) ; } }
        <C>
    )*
}