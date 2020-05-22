public double distance (int x, int y){
    int xdist = x-startx;
    int ydist = y-starty;

    int squarex = xdist*xdist
    int squarey = ydist*ydist

    return Math.sqrt((double)(squarex+squarey));
}