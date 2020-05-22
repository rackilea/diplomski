for (int j = 0; j < 20; j++)
    {   
        g.setColor(Color.RED);  //set non-intersect state
        for (int k = j + 1; k < 20; k++)  //avoid excessive work
        {   
                if (intersect test)
                  {
                    g.setColor(Color.BLACK);
                    break; //can stop here
                  };
            g.drawOval(x[j], y[j], diameter[j], diameter[j]);
        }
}