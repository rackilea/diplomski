import ge.game.Tile;

public class Sprite {   
public static Sprite grass = new Sprite(0, 0, Spritesheet.testTiles);
...

import ge.graphics.Sprite;

public class Tile {
public static Tile grass = new Tile("grass", Sprite.grass);
public static int TILE_SIZE = 16;
...