public static void moveTile(Tile tile, int x, LinearLayout parent) {
    if (x < 0) {

        int t = Math.abs(x) / tile.getWidth() + 1;

        if (tile.getId() - t >= 0) {
            Tile new_tile = (Tile) parent.findViewById(tile.getId() - t);

            parent.removeViewAt(new_tile.getId());
            parent.addView(new_tile, tile.getId());

            int id = tile.getId();
            tile.setId(new_tile.getId());
            new_tile.setId(id);
        }
    } else if (x > tile.getWidth()) {

        int t = x / tile.getWidth();

        if (tile.getId() + t < word.length()) {
            Tile new_tile = (Tile) parent.findViewById(tile.getId() + t);

            parent.removeViewAt(new_tile.getId());
            parent.addView(new_tile, tile.getId());

            int id = tile.getId();
            tile.setId(new_tile.getId());
            new_tile.setId(id);
        }
    }
}