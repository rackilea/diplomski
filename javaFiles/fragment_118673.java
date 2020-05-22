public Boolean isOutOfBounds(int x, int y, String d){
    if(d.equalsIgnoreCase("N")){
        y--;
    }
    if(d.equalsIgnoreCase("S")){
        y++;
    }
    if(d.equalsIgnoreCase("E")){
        x--;
    }
    if(d.equalsIgnoreCase("W")){
        x++;
    }
    return ! (x >= 0 && x < maze.length &&  y >= 0 && y < maze.length);
}