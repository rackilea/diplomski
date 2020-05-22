List<Tile> tiles = new ArrayList<Tile>();

Tile a = new GrassTile(); //GrassTile extends Tile
Tile b = new StoneTile(); //StoneTile extends Tile

tiles.add(a);
tiles.add(b);

for(Tile t : tiles){
   t.doTileStuff();
}