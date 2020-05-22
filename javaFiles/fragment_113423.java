rule findMin
when
    $mina: A( $edges: edges )
    not A( edges.size() < $edges.size() )
then
    System.out.println( "retract " + $mina );
    retract( $mina );
end

rule countFail extends findMin
when
    eval( $edges.size() == 0 )
then
    Main.counter++;
    System.out.println( "fail to match " + $mina );
end

rule matchLP extends findMin
when
    $l: L( this memberOf $edges, $p: p )
then
    retract( $p );
    retract( $l );
    System.out.println( "retract " + $p + " and " + $l );
end

rule cleanup
salience 10
when
    $l: L( $p: p )
    not P( this == $p )
    $a: A( edges contains $l )
then
    retract( $l );
    modify( $a ){
        remove( $l );
    }
    System.out.println( "cleanup " + $l + ", " + $a );
end