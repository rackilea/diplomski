private static void initializeMap( MapData mapData )
{
    int rows = mapData.getMapRows();
    int columns = mapData.getMapColumns();
    int[][] map = mapData.getMap();

    int counter = 0;
    for ( int x = 0; x < rows; x++ )
    {
        for ( int y = 0; y < columns; y++ )
        {
             map[x][y] = counter;
             counter++;
        }
    }
}