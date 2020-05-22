rdd1.
    // ( x, [ y1, ..., yn ] ) -> ( x, x ), ( y1, x ), ..., ( yn, x )
    flatMap { case ( x, ys ) => ( x :: ys ).map( ( _, x ) ) }.
    // ( xory, x ) -> ( xory, ( x, rdd2.lookup( xory ) ) )
    leftOuterJoin( rdd2 ).
    // ( xory, ( x, rdd2.lookup( xory ) ) ) -> ( x, rdd2.lookup( xory ) )
    map( _._2 ).
    // ( x, rdd2.lookup( x ) ), ... -> ( x, rdd2.lookup( x ) + sum_i( rdd2.lookup( y_i ) )
    reduceByKey{ case ( dopt1, dopt2 ) => ( dopt1 ++ dopt2 ).reduceOption( _ + _ ) }.
    // unwrap the option types
    mapValues( _.getOrElse( 0.0 ) )