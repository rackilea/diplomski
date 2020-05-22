// vertically
for (int c = 0; r<grid.getNumCols(); c++)
{
    Piece col0 = grid.get(new Location(0,c));
    Piece col1 = grid.get(new Location(1,c));
    Piece col2 = grid.get(new Location(2,c));

    if(col0 == null || col1 == null || col2 == null)
    {
        continue;
    }

    if(col0.getName().equals(col1.getName()) && col0.getName().equals(col2.getName()))
    {
        winner = col0.getName()+ " wins vertically!";
        break;
    }
}

// diagonal 1
for (int x = 0; r<grid.getNumRows(); x++)
{
    Piece d0 = grid.get(new Location(x,x));
    Piece d1 = grid.get(new Location(x,x));
    Piece d2 = grid.get(new Location(x,x));

    if(d0 == null || d1 == null || d2 == null)
    {
        continue;
    }

    if(d0.getName().equals(d1.getName()) && d0.getName().equals(d2.getName()))
    {
        winner = d0.getName()+ " wins diagonally!";
        break;
    }
}

// diagonal 2
for (int x = 0; r<grid.getNumRows(); x++)
{
    Piece d0 = grid.get(new Location(x,2-x));
    Piece d1 = grid.get(new Location(x,2-x));
    Piece d2 = grid.get(new Location(x,2-x));

    if(d0 == null || d1 == null || d2 == null)
    {
        continue;
    }

    if(d0.getName().equals(d1.getName()) && d0.getName().equals(d2.getName()))
    {
        winner = d0.getName()+ " wins diagonally!";
        break;
    }
}