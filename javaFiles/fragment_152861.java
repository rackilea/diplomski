switch(whodealt) {
    case WEST:
        // startActivityForResult() etc. passing WEST;
        // process result
        // fall through

    case NORTH:
        // startActivityForResult() etc. passing NORTH;
        // process result
        // fall through

    case EAST:
        // startActivityForResult() etc. passing EAST;
        // process result
        // fall through

    case SOUTH: // (the player dealt themselves)
        break;
    default:
        throw new IllegalArgumentException("Unrecognised Dealer");
}