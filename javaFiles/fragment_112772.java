int times = 5;//how many numbers to output

    for(int i = 0; i < times; i++)
    {
        System.out.println((int)(Math.random()*10));
        //you must cast the output of Math.random() to int since it returns double values
    }