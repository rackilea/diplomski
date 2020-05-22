public void initSize(int _width, int _height)
  {
    int h = background.getHeight(null);
    int w = background.getWidth(null);

    if (w - _width > h - _height)
    {
      scaleVertically(_width, _height);
    }
    else
    {
      scaleHorizontally(_width, _height);
    }
  }