long time1 = System.currentTimeMillis();
while(running){
    long time2 = System.currentTimeMillis();
    float timeDiff = (time2-time1)/1000f;
    time1 = time2;
    tick(timeDiff);
}