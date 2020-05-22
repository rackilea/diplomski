boolean isShot(Rocket myRocket) {
  if (alien1.x == 40)
  {
    if (alien1.y>=y && alien1.y<=(y+50))
    {
      return true;
    }
    return false;
  }
}