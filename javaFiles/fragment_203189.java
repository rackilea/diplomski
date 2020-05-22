int x = 10000;
long before = System.currentTimeMillis();
while (System.currentTimeMillis() - before < x){
    Thread.sleep(x);
    // Processing
}