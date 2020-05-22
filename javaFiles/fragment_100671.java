String param = getParam(); // get the '1' or 'plane' string from your input
    BlockType type = null;
    try {
        // Check for an integer
        int id = Integer.parseInt(param);
        type = BlockType.getFromId(id);
    } catch( NumberFormatException e ) {
        // Okay, not an integer, check the lookup value
        type = BlockType.lookup(param);
    }

    if( type != null ) {
                int blockid = type.getID();
                String blockname = type.getName();
                // continue on
    } else {
    // else the input parameter was invalid and we can't get a BlockType for it
    // return some kind of error
    }