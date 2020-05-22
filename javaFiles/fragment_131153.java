public void render(int n, SpriteBatch batch) {
    String string = Integer.toString(n);
    for(int i = 0; i < string.length(); ++i) 
        batch.draw(Assets.numbers[0][string.charAt(i) - '0'],
                   pos.x + (50 * i), pos.y);
}