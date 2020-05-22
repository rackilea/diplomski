public static void Dvz(String s, int x, int y){
    int i;
    if(y > 0)
      for(i = x; i >= y; i--)
      Dvz(s+i, i-1, y-1);
    else
      System.out.println(s);

  }