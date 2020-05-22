private static final Object arbiter = new Object( );

void move(dir direction)
{
  ...
  TileManager tileManager = TileManager.getInstance( );

  synchronized( arbiter )
  {
    PlayField tarXtarYField = tileManager.playField[tarX][tarY];

    synchronized( tarXtarYField )
    {
      ...

      PlayField xyField = tileManager.playField[x][y];
      synchronized( xyField )
      {
        ...
        tileManager.playField[prevX][prevY].notify();
        xyField.notify();
      }
    }
  }
}