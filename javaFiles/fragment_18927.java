Point2D A = new Point2D.Double( 1.0, 2.0 );
    Point2D B = new Point2D.Double( 2.0, 1.0 );

    Ellipse2D E = new Ellipse2D.Double( 1.0, 2.0, 2.0, 1.0 );

    double x = 1.0;
    double c=0; // Keep compiler from optimizing
    boolean y = false;

    long start = System.currentTimeMillis();
    for( long i=0; i<1000000000L; i++ ){
        y |= E.contains( B );
    }
    long durA = System.currentTimeMillis() - start;

    start = System.currentTimeMillis();
    for( long i=0; i<1000000000L; i++ ){
        c += A.distance( B ) - x/2.0;
    }
    long durB = System.currentTimeMillis() - start;

    System.out.println( y ); // Keep compiler from optimizing
    System.out.println( c );
    System.out.printf( "%d / %d", durA, durB );