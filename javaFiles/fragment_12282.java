private int X_SIZE = 155;


public int getX(int position) {
    return position % X_SIZE;   // Starts from 0
}

public int getY(int position) {
    return position / X_SIZE;   // starts from 0
}