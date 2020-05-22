List<String> movements = new ArrayList<>();
while(System.currentTimeMillis() < end) {
    if (steve.Obstacle(true)){ // if a obstacle is found.
        movements.add("stopped");
    }
    else if(steve.stop(true)) {
        movements.add("forward");
    }
    Thread.sleep(whatever);
}