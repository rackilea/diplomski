public void drawSpriteForBody(Body body, Sprite sprite, SpriteBatch spriteBatch) {
    Vector2 offset = new Vector2(sprite.getWidth() / 2f, sprite.getHeight() / 2f);
    Vector2 position = body.getPosition().cpy().scl(Constants.PIXELS_PER_METER).sub(offset);
    float rotation = body.getAngle() * MathUtils.radiansToDegrees;
    sprite.setRotation(rotation);
    sprite.setPosition(position.x, position.y);

    sprite.draw(spriteBatch);
}