if (isTileValid(potentialNext)) {
    // do stuff
}


private boolean isTileValid(TileObject someTile) {
    if (someTile.wall()) {
        return false;
    }
    if (someTile.door()) {
        return false;
    }
    if (! check(someTile)) {
        return false;
    }
    return true;
}