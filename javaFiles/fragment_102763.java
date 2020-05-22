for(int time=0; time <= 30 && bounce < 5; time++) //counter, bails out if bounce > 5
    {
        if(time >= 0)
        {
        height = height + vel;
        vel = vel - 32.0;
        }

        if(height < 0)
        {
            height = height * -0.5;
            vel = vel * -0.5;
            System.out.println("BOUNCE!");
            bounce++;
        }
        System.out.println("time: "+time+" "+"height: "+height);
    }