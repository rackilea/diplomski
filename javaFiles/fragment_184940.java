for (int i = 0; i < mapSquaresTemp.length; i++)
{
    for (int j = mapSquares[0].length; j < mapSquaresTemp[0].length; j++)
    {
        MapSquare temp = new MapSquare(i, j);
        mapSquaresTemp[i][j] = temp;

    }
}