String[][] level = {
  {"g", "r", "g"},
  {" ", "x", "t"},
  //...
};

for (int y = 0; y < level[0].length; y++)
{
  for (int x = 0; x < level.length; x++)
  {
      if (level[x][y].equals("g"))
        draw(groundTile, x * tilewidth, y * tileheight);
      else if (level[x][y].equals("x"))
        draw(otherTile, x * tilewidth, y * tileheight);
  }
}