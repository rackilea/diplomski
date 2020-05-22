for(int i = 0; i < zombies.size(); i++){
    Zombie z = (Zombie) zombies.get(i);

    // New code here:
    int x = z.getX();
    int y = z.getY();
    attemptZombieMove(z);

    Rectangle r2 = z.getBounds();
    for(int j = 0; j < zombies.size(); j++){
        if (i == j) {
            continue;
        }
        Zombie z2 = (Zombie) zombies.get(j);
        Rectangle r1 = z2.getBounds();
        if(r2.intersects(r1)){
            //the code for stoping the sprites from going through each other should be here
        }
    }
}