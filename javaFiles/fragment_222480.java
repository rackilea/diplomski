for (int i = 0; i < Scheme.rows; ++i)
{
  for (int j = 0; j < Scheme.cols; ++j)
  {
    g2.drawRect(i*32, j*32, 32, 32);

    if (Scheme.scheme[i][j].isBlank)
      g2.fillRect(i*32 + 3, j*32 + 3, 32 - 5, 32 - 5);
  }
}