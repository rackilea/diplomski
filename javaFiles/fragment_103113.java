private void createNewSprite() {
    Sprite sprite = new Sprite(spriteMap.get(name)); //creates a new sprite that is a copy of the one in your map.
    sprite.setPosition(x, y);
    sprite.rotate(rotation);
    spriteArray.add(sprite);
}