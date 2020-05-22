while(System.currentTimeMillis() < end) {
    if (steve.Obstacle(true)){ // if a obstacle is found.
        stop.add(1);
    }
    else if(steve.stop(true)) {
        forward.add(1);
    }
    Thread.sleep(whatever);
}