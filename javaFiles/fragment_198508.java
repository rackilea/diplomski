float delay = 0.5f; // seconds

Timer.schedule(new Task(){
    @Override
    public void run() {
        // Do your work
        if(world.map[mapPos].ID == 9) {
            updateWater(mapPos);
        }
    }
}, delay, delay);