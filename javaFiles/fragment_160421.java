private static void drawMap( MapData mapData )
{
    int rows = mapData.getMapRows();
    int columns = mapData.getMapColumns();
    int[][] map = mapData.getMap();

    for ( int q = 0; q < rows; q++ )
    {
        for ( int x = 0; x < columns; x++ )
        {
            System.out.printf( "%-2d", map[q][x] );
            System.out.print( "|" );
        }
            System.out.println( "" );
    }
}