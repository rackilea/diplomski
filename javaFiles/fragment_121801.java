public Set<Block> getConnectedblocks(Block block) {
    Set<Block> set = new HashSet<>();
    LinkedList<Block> list = new LinkedList<>();

    //Add the current block to the list of blocks that are yet to be done
    list.add(block);

    //Execute this method for each block in the 'todo' list
    while((block = list.poll()) != null) {
        getConnectedblocks(block, set, list);
    }
    return set;
}