class Player {

    // [...]
    boolean move_up = false, move_down = false;

    void pressed(boolean up, boolean down) {
        if (up)   {move_up   = true;}
        if (down) {move_down = true;}
    }

    void released(boolean up, boolean down) {
        if (up)   {move_up   = false;}
        if (down) {move_down = false;}
    }
}