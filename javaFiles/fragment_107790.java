int left = INT_MAX, right = -1, top = INT_MAX, bottom = -1
for (int y = 0; y < Y; y++)
  for (int x = 0; x < X; x++)
    if (t[x][y] == 'x')
    {
      if (left > x) left = x
      if (right < x) right = x
      if (top > y) top = y
      bottom = y // we don't need if! :)
    }