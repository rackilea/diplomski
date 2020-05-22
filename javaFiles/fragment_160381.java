static String toHex( float t ){
    int sign = 0;
    if( t < 0 ){
        sign = 0x8000;
        t = -t;
    }
    short it = (short)(Math.round(t*10) + sign);
    return String.format( "%04x", it );
}

static float toDec( String s ){
    int it = Integer.parseInt( s, 16 );
    if( it > 32767 ){
        it = -(it - 0x8000);
    }
    return it/10.0F;
}