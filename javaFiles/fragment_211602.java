public class Sprite {   
public static Sprite grass = new Sprite(0, 0, Spritesheet.testTiles);
public static int SPRITE_SIZE = 16;
...

import ge.graphics.Sprite;

public class Tile {
public static Tile grass = new Tile("grass", Sprite.grass);
...