while(isRunning()) {
    Value v = queue.take();
    if(v == POISON) {
        break;
    }
    // do something with v
}