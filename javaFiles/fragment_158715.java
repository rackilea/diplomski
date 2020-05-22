if (up <= down) {
        swap(up,down);
        if(pivot == up) { pivot = down; }
        else if(pivot == down) { pivot = up; }
        up++;
        down--;
    }