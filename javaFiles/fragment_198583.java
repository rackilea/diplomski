static MediaPlayer mp = null;

// ...

private void moveTile(Tile tile, Cell cell) {
        grid.field[tile.getX()][tile.getY()] = null;
        grid.field[cell.getX()][cell.getY()] = tile;
        tile.updatePosition(cell);

        try
        {
            if (mp != null)
            {
                if (mp.isPlaying ())
                    mp.stop ();

                mp.reset ();
                mp.release ();
                mp = null;
            }

            mp = MediaPlayer.create (getApplicationContext (), R.raw.movetile);

            if (mp != null)
            {
                mp.start ();
            }
            else
            {
                // Handle the error ...
            }

        } catch (Exception e)
        {
            // Handle the error ...
        }
}