grid = new ArrayList<ArrayList<ArrayList<Entity>>>();
for(ArrayList<ArrayList<Block> blockList1 : ctgf.blockMap) {
    ArrayList<ArrayList<Entity>> entityList1 = new ArrayList<ArrayList<Entity>>();
    for(ArrayList<Block> blockList2: blockList1) {
        entityList1.add(new ArrayList<Entity>(blockList2));
    }
    grid.add(entityList1);
}