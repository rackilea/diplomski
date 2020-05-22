public class Peach {
    private static enum Tile {
        Water("~"), Sand("."), Plain("\""), Forest("#"), Hill("#");

        public String tile;

        Tile(String tile) {
            this.tile = tile;
        }

    }

    Map<Tile, List<Tile>> constrains = new HashMap<>();
    {
        constrains.put(Tile.Water,
                Arrays.asList(Tile.Water, Tile.Sand, Tile.Plain));
        constrains.put(Tile.Sand,
                Arrays.asList(Tile.Water, Tile.Sand, Tile.Plain));
        constrains.put(Tile.Plain,
                Arrays.asList(Tile.Water, Tile.Sand, Tile.Plain, Tile.Forest));
        constrains.put(Tile.Forest, Arrays.asList(Tile.Hill, Tile.Plain));
        constrains.put(Tile.Hill, Arrays.asList(Tile.Hill, Tile.Forest));
    }


    public Tile[][] generate(int x, int y) {

        Random rand = new Random();
        Tile[][] map = new Tile[x][y];

        for (int i = 0; i < x; i++) {
            map[i][0] = Tile.Water;
            map[i][y - 1] = Tile.Water;
        }

        for (int i = 0; i < y; i++) {
            map[0][i] = Tile.Water;
            map[x - 1][i] = Tile.Water;
        }

        for (int i = 1; i < x - 1; i++) {
            for (int j = 1; j < y - 1; j++) {
                List<Tile> con1 = constrains.get(map[i][j-1]);
                List<Tile> con2 = constrains.get(map[i-1][j]);
                List<Tile> con = new ArrayList<Peach.Tile>();
                for (Tile tile : con1){
                    if (con2.contains(tile)){
                        con.add(tile);
                    }
                }
                if (con.isEmpty()){
                    con.add(Tile.Plain);
                }

                map[i][j] = con.get(rand.nextInt(con.size()));

            }
        }

        return map;
    }

    public static void main(String[] args) {
        Peach p = new Peach();
        Tile[][] map = p.generate(20, 10);
        System.out.print("\n");
        for (Tile[] line : map) {
            for (Tile tile : line) {
                System.out.print(tile.tile);
            }
            System.out.print("\n");
        }
    }

}