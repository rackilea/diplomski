public static void main( String[] args )
{
    Scanner scanner = new Scanner( System.in );
    MapData mapData = createMap( scanner );

    initializeMap( mapData );
    drawMap( mapData );
    System.out.println();
    System.out.println( "You Start At 0" );

    takeAStep( scanner, mapData );
    drawMap( mapData );
    System.out.println();

    takeAStep( scanner, mapData );
    drawMap( mapData );
}