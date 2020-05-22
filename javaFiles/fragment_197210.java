private void newEnemy(){
    Sprite newEnemy = Pools.obtain(Sprite.class);
    newEnemy.set(enemy); //reference same Texture from your prototype enemy sprite
    //set up enemy position and other parameters here
    enemies.add(newEnemy);
}