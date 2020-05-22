int[][] STARTING_CLUES = {
        {2, 0, 0, 3, 0, 3},
        {0, 1, 4, 0, 4, 0},
        {0, 0, 0, 0, 0, 0},
        {3, 0, 3, 0, 2, 0},
        {0, 0, 0, 1, 0, 2},
        {2, 0, 4, 0, 2, 0}
};

void search(){

    Map<Point, List<Direction>> remainingOptions = new HashMap<>();

    Stack<Land> gameTree = new Stack<>();
    gameTree.push(new Land(STARTING_CLUES));

    while(true){

        Land state = gameTree.peek();
        int[] p = state.lowestTodo();
        if (p == null)
            System.out.println("solution found");

        // move to next game state
        int r = p[0];
        int c = p[1];
        System.out.println("expanding game state for node at (" + r + ", " + c + ")");

        List<Direction> ds = null;
        if(remainingOptions.containsKey(new Point(r,c)))
            ds = remainingOptions.get(new Point(r,c));
        else{
            ds = new ArrayList<>();
            for(Direction dir : Direction.values()) {
                int[] tmp = state.nextIsland(r, c, dir);
                if(tmp == null)
                    continue;
                if(state.canBuildBridge(r,c,tmp[0], tmp[1]))
                    ds.add(dir);
            }
            remainingOptions.put(new Point(r,c), ds);
        }

        // if the node can no longer be expanded, and backtracking is not possible we quit
        if(ds.isEmpty() && gameTree.isEmpty()){
            System.out.println("no valid configuration found");
            return;
        }

        // if the node can no longer be expanded, we need to backtrack
        if(ds.isEmpty()){
            gameTree.pop();
            remainingOptions.remove(new Point(r,c));
            System.out.println("going back to previous decision");
            continue;
        }

        Direction dir = ds.remove(0);
        System.out.println("connecting " + dir.name());
        remainingOptions.put(new Point(r,c), ds);

        Land nextState = new Land(state);
        int[] tmp = state.nextIsland(r,c,dir);
        nextState.connect(r,c, tmp[0], tmp[1]);
        gameTree.push(nextState);

    }

}

public static void main(String[] args) {
    new Main().search();
}