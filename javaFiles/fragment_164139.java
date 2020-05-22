public class Land {

private int[][] BRIDGES_TO_BUILD;

private boolean[][] IS_ISLAND;
private Direction[][] BRIDGES_ALREADY_BUILT;

public Land(int[][] bridgesToDo){
    BRIDGES_TO_BUILD = copy(bridgesToDo);

    int R = bridgesToDo.length;
    int C = bridgesToDo[0].length;
    BRIDGES_ALREADY_BUILT = new Direction[R][C];
    IS_ISLAND = new boolean[R][C];
    for(int i=0;i<R;i++) {
        for (int j = 0; j < C; j++) {
            BRIDGES_ALREADY_BUILT[i][j] = null;
            IS_ISLAND[i][j] = bridgesToDo[i][j] > 0;
        }
    }
}

public Land(Land other){
    BRIDGES_TO_BUILD = copy(other.BRIDGES_TO_BUILD);
    int R = BRIDGES_TO_BUILD.length;
    int C = BRIDGES_TO_BUILD[0].length;
    BRIDGES_ALREADY_BUILT = new Direction[R][C];
    IS_ISLAND = new boolean[R][C];
    for(int i=0;i<R;i++) {
        for (int j = 0; j < C; j++) {
            BRIDGES_ALREADY_BUILT[i][j] = other.BRIDGES_ALREADY_BUILT[i][j];
            IS_ISLAND[i][j] = other.IS_ISLAND[i][j];
        }
    }
}

public int[] next(int r, int c, Direction dir){
    int R = BRIDGES_TO_BUILD.length;
    int C = BRIDGES_TO_BUILD[0].length;

    // out of bounds
    if(r < 0 || r >=R || c < 0 || c >= C)
        return null;


    // motion vectors
    int[][] motionVector = {{-1, 0},{0,1},{1,0},{0,-1}};
    int i = Arrays.asList(Direction.values()).indexOf(dir);

    // calculate next
    int[] out = new int[]{r + motionVector[i][0], c + motionVector[i][1]};

    r = out[0];
    c = out[1];

    // out of bounds
    if(r < 0 || r >=R || c < 0 || c >= C)
        return null;

    // return
    return out;
}

public int[] nextIsland(int r, int c, Direction dir){
    int[] tmp = next(r,c,dir);
    if(tmp == null)
        return null;
    while(!IS_ISLAND[tmp[0]][tmp[1]]){
        tmp = next(tmp[0], tmp[1], dir);
        if(tmp == null)
            return null;
    }
    return tmp;
}

public boolean canBuildBridge(int r0, int c0, int r1, int c1){
    if(r0 == r1 && c0 > c1){
        return canBuildBridge(r0, c1, r1, c0);
    }
    if(c0 == c1 && r0 > r1){
        return canBuildBridge(r1, c0, r0, c1);
    }
    if(r0 == r1){
        int[] tmp = nextIsland(r0, c0, Direction.EAST);
        if(tmp[0] != r1 || tmp[1] != c1)
            return false;
        if(BRIDGES_TO_BUILD[r0][c0] == 0)
            return false;
        if(BRIDGES_TO_BUILD[r1][c1] == 0)
            return false;
        for (int i = c0; i <= c1 ; i++) {
            if(IS_ISLAND[r0][i])
                continue;
            if(BRIDGES_ALREADY_BUILT[r0][i] == Direction.NORTH)
                return false;
        }
    }
    if(c0 == c1){
        int[] tmp = nextIsland(r0, c0, Direction.SOUTH);
        if(tmp[0] != r1 || tmp[1] != c1)
            return false;
        if(BRIDGES_TO_BUILD[r0][c0] == 0 || BRIDGES_TO_BUILD[r1][c1] == 0)
            return false;
        for (int i = r0; i <= r1 ; i++) {
            if(IS_ISLAND[i][c0])
                continue;
            if(BRIDGES_ALREADY_BUILT[i][c0] == Direction.EAST)
                return false;
        }
    }
    // default
    return true;
}

public int[] lowestTodo(){
    int R = BRIDGES_TO_BUILD.length;
    int C = BRIDGES_TO_BUILD[0].length;

    int[] out = {0, 0};
    for (int i=0;i<R;i++) {
        for (int j = 0; j < C; j++) {
            if(BRIDGES_TO_BUILD[i][j] == 0)
                continue;
            if (BRIDGES_TO_BUILD[out[0]][out[1]] == 0)
                out = new int[]{i, j};
            if (BRIDGES_TO_BUILD[i][j] < BRIDGES_TO_BUILD[out[0]][out[1]])
                out = new int[]{i, j};
        }
    }
    if (BRIDGES_TO_BUILD[out[0]][out[1]] == 0) {
        return null;
    }
    return out;
}

private int[][] copy(int[][] other){
    int[][] out = new int[other.length][other.length == 0 ? 0 : other[0].length];
    for(int r=0;r<other.length;r++)
        out[r] = Arrays.copyOf(other[r], other[r].length);
    return out;
}

public void connect(int r0, int c0, int r1, int c1){
    if(r0 == r1 && c0 > c1){
        connect(r0, c1, r1, c0);
        return;
    }
    if(c0 == c1 && r0 > r1){
        connect(r1, c0, r0, c1);
        return;
    }
    if(!canBuildBridge(r0, c0, r1, c1))
        return;

    BRIDGES_TO_BUILD[r0][c0]--;
    BRIDGES_TO_BUILD[r1][c1]--;

    if(r0 == r1){
        for (int i = c0; i <= c1 ; i++) {
            if(IS_ISLAND[r0][i])
                continue;
            BRIDGES_ALREADY_BUILT[r0][i] = Direction.EAST;
        }
    }
    if(c0 == c1){
        for (int i = r0; i <= r1 ; i++) {
            if(IS_ISLAND[i][c0])
                continue;
            BRIDGES_ALREADY_BUILT[i][c0] = Direction.NORTH;
        }
    }
}
}