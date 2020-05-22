// your fields
Random r = new Random();
int lastAmount = 0;

// your spawning method
if(hud.getLevel % 10 != 0) {
    int amount = r.nextInt(2) + 1 + lastAmount;
    lastAmount = amount;
    for(int i = 0; i < amount; i++) {
        // you can have another random generation for enemy types in here
        handler.addObject(... // add your enemy
    }
} else {
    // spawn your boss
}