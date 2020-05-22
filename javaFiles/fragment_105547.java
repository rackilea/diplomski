static HashMap<Coordinate, Integer> getTreeCoordinates(Tree tree, int x, int y, int maxWidth){
    HashMap<Coordinate, Integer> result = new HashMap<>();
    return getTreeCoordinatesImpl(tree, x, y, maxWidth, result);
}

static void getTreeCoordinatesImpl(Tree tree, int x, int y, int maxWidth, HashMap<Coordinate, Integer> result){
    result.put(new Coordinate(x, y), tree.data);
    if (tree.right != null){
        getTreeCoordinatesImpl(tree.right, x+maxWidth/(int)Math.pow(2, y+1) + 1, y+1, maxWidth, result);
    }
    if (tree.left != null){
        getTreeCoordinatesImpl(tree.left, x-maxWidth/(int)Math.pow(2, y+1) - 1, y+1, maxWidth, result);
    }
}