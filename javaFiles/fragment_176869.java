String temp;
try {
    while(true) {
        temp = handler.bq.take();
        // process temp
    }
catch (InterruptedException ex) {
    // ignore exception
}
while((temp = handler.bq.poll()) != null) {
    // process temp
}