public void change(Point a)
    {
      a.x=10; //reference is copied but same, so value will change 
    }
Point x;
change(x);