long t1 = comm1.getDate().getTime();
    long t2 = comm2.getDate().getTime();
    if(t2 > t1)
            return 1;
    else if(t1 > t2)
            return -1;
    else
            return 0;