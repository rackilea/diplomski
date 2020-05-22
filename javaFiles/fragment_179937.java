private static void groupByX(Map<Integer, List<Integer>> xMap, List<AABB> aabbPool) {
    //for each X
    for (Entry<Integer, List<Integer>> entry : xMap.entrySet()) {
        List<Integer> curList = entry.getValue();
        if (curList != null) {
            int curY = curList.get(0); //current yCoord
            int curH = 1; //current height
            //for each Y
            for (int i = 1; i < curList.size(); i++) {
                if (curY + curH == curList.get(i)) {
                    curH++;
                } else {
                    aabbPool.add(new AABB(entry.getKey()*Tile.SIZE, curY*Tile.SIZE, Tile.SIZE, curH*Tile.SIZE)); // *Tile.SIZE()
                    //reset
                    curY = curList.get(i);
                    curH = 1;
                }
            }
            //add the last AABB
            aabbPool.add(new AABB(entry.getKey()*Tile.SIZE, curY*Tile.SIZE, Tile.SIZE, curH*Tile.SIZE));
        }
    }
}