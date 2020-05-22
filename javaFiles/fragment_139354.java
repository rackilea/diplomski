long lastCall = 0;

while(bla) {
    if(System.currentTimeMillis() - lastCall > 30000) {
        lastCall = System.currentTimeMillis();
        callTheFunction();
    }
}