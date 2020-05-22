drawHex ( g, cx, cy, 0 );

    for ( int rank = 1; rank < count; ++rank ) {

        for ( int bar = 0; bar < 6; ++bar ) {
            // x and y are twice midpoint of the previous face * the rank away 
            // from centre
            int x = cx + ( polyX [ ( bar + 4 ) % 6 ] + polyX [ ( bar + 5 ) % 6 ] ) * rank;
            int y = cy + ( polyY [ ( bar + 4 ) % 6 ] + polyY [ ( bar + 5 ) % 6 ] ) * rank;

            // move by twice the distance of the midpoint of the next face each time 
            int dx = polyX [ bar ] + polyX [ ( bar + 1 ) % 6 ];
            int dy = polyY [ bar ] + polyY [ ( bar + 1 ) % 6 ];

            for ( int hex = 0; hex < rank; ++hex ) {
                drawHex ( g, x, y, rank );
                x += dx;
                y += dy;
            }
        }
    }