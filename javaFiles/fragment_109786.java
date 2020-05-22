public class Tiles {
    //collection of tiles
    Tile[] tiles = new Tiles[37];


   // in the constructor initialize each individual tile with an arraylist
    public Tiles (){

        for(int i=0; i<tiles.length;i++)
        {
            tiles[i] = new ArrayList();
        }
    }
}