public void rollDie(){
    Die bob = new Die();
    int total = 0;
    for(int i = 0; i < 3; i++){
        die[i] = bob.rollDie();
        bob.displayDie(die[i]);
        total = total + die[i];
    }
    bob.displayDie(total);
}