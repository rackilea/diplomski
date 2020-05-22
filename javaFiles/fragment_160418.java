public class MapData
{
    private int     mapRows;
    private int     mapColumns;
    private int[][] map;

    public MapData( int mapRows, int mapColumns, int[][] map )
    {
         this.mapRows = mapRows;
         this.mapColumns = mapColumns;
         this.map = map;
    }

    public int getMapRows()
    {
         return mapRows;
    }

    public int getMapColumns()
    {
        return mapColumns;
    }

    public int[][] getMap()
    {
        return map;
    }
}