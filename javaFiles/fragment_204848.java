while(p <= (int)(Math.sqrt(N))){
    t[p%cores].start();//
    try{
        t[p%cores].join(); //<--- BUG, only the thread which was just started can be running now
    }catch(Exception e){}
    //get the next prime
    p++;
    while(p<=(int)(Math.sqrt(N))&&f[p]==0)p++;
}