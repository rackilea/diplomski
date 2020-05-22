int x = 10;
    @Override
    public void setValue(int n)
    {
        if((n >= -x && n < -1)|| (n =< x && n >= 1))
        {   
            super.setValue(n);
            System.out.println("OI in setValue");
        }
    }