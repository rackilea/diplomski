private Runnable SpawnEnemies = new Runnable(){
    public void run(){
        //Your code here...

        spawnHandler.postDelayed(2000, this);
    }
};