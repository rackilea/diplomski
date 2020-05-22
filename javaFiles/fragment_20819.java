public double area()
  {
    double sum = 0;
    for (int i = 0; i < vertices.length ; i++)
    {
      if (i == 0)
      {
        System.out.println(vertices[i].x + "x" + (vertices[i + 1].y + "-" + vertices[vertices.length - 1].y));
        sum += vertices[i].x * (vertices[i + 1].y - vertices[vertices.length - 1].y);
      }
      else if (i == vertices.length - 1)
      {
        System.out.println(vertices[i].x + "x" + (vertices[0].y + "-" + vertices[i - 1].y));
        sum += vertices[i].x * (vertices[0].y - vertices[i - 1].y);
      }
      else
      {
        System.out.println(vertices[i].x + "x" + (vertices[i + 1].y + "-" + vertices[i - 1].y));
        sum += vertices[i].x * (vertices[i + 1].y - vertices[i - 1].y);
      }
    }

    double area = 0.5 * Math.abs(sum);
    return area;

  }