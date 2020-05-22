private static void takeAStep( Scanner scanner, MapData mapData )
{
    System.out.println( "Pick the number you want to go to" );
    int steppedTile = scanner.nextInt();
    updateMap( mapData, steppedTile );
}

private static void updateMap( MapData mapData, int steppedTile )
{
    int rows = mapData.getMapRows();
    int columns = mapData.getMapColumns();
    int[][] map = mapData.getMap();

    for ( int q = 0; q < rows; q++ )
    {
        for ( int x = 0; x < columns; x++ )
        {
            if ( map[q][x] == steppedTile )
            {
                map[q][x] = 0;
            }
        }
   }
}