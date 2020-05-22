for (int i = 0; i < levelPixels.length; i++)
{
    if (levelPixels[i] == 0x24ff) {
        tiles[i] = new GrassTile(manager.get("grass.png", Texture.class),
                new Vector2(i * 10, i * 10),
                new Vector2(10, 10));
    } else if (levelPixels[i] == 0x8b8b8b) {
        tiles[i] = new ConcreteTile(manager.get("concrete.png", Texture.class),
                new Vector2(i * 10, i * 10),
                new Vector2(10, 10));
    } else {
        tiles[i] = new GrassTile(manager.get("grass.png", Texture.class),
                new Vector2(i * 10, i * 10),
                new Vector2(10, 10));
    }
}