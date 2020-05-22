void randomBug(Bug x, double y, int n)
{
    if( n <= 0 ) //separated repeated use of requirement
        return;

    if( [...] )
        x.setDirection( ... );
    else if ( [...] )
        x.setDirection( ... );
    [ more else ifs as needed ]

    if( x.canMove() ) //separated repeated use of action
        x.move();

    randomBug(x, Math.random(), n-1);
}