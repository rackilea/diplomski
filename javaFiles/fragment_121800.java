private void getConnectedblocks(Block block, Set<Block> results, List<Block> todo) {
    //Here I collect all blocks that are directly connected to variable 'block'.
    //(Shouldn't be more than 6, because a block has 6 sides)
    Set<Block> result = results;

    //Loop through all block faces (All 6 sides around the block)
    for(BlockFace face : faces) {
        Block b = block.getRelative(face);
        //Check if they're both of the same type
        if(b.getType() == block.getType()) {
            //Add the block if it wasn't added already
            if(result.add(b)) {

                //Add this block to the list of blocks that are yet to be done.
                todo.add(b);
            }
        }
    }