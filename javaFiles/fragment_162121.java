void makeBubble(){
    Bubble bubble = new Bubble();
    bubble.x = (int)(random.nextFloat() * Gdx.graphics.getWidth());
    bubble.y = Gdx.graphics.getHeight();
    bubble.textureIndex = random.nextInt(3);
}