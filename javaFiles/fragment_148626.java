public boolean willCollide(int row, int col, Board map)
{
    return map[row][col] == 1;
}

public void moveLeft(Hero hero, Board map)
{
  //watch for index out of bounds!
  int futureCol = hero.y - 1;
  if (! willCollide(hero.row, futureCol)
    hero.y = futureCol;
}