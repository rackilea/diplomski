public class Tile {

private int x, y;
private int type;
private int[][] neighbors;

public Tile(int x, int y, int type){
    this.x = x;
    this.y = y;
    this.type = type;

    findNeighbors();
}

private void findNeighbors(){
    int[] top = new int[] {x, y+1};
    int[] right = new int[] {x+1, y};
    int[] bottom = new int[] {x, y-1};
    int[] left = new int[] {x-1, y};

    neighbors = new int[][] {top, right, bottom, left};
}

public int getType() {
    return type;
}

public int[] getNeigbor(int side) {
    if(side == 0) {
        return neighbors[0];
    }
    //etc
    return null;
}
}