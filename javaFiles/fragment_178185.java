double bg = 5.0;
  double f = 0.0;
  for(double i = 0; i <= bg; i += 1)
    {
        f = f + ((2 * i + 1)*0.1);

        if (Math.abs(i - bg) < 0.00001f)
        {
            System.out.printf ("%.1f" , f);
        }
    }