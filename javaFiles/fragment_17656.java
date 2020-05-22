private boolean OnLava()
{
    for (Entity e : world.getEntities(PLAYER)) {

        float playerX = e.get(Position.class).getX();
        float playerY = e.get(Position.class).getY();

        int tileRow = (int) (playerX / currentLayer.getTileWidth() - (playerY / currentLayer.getTileHeight()));
        int tileCol = (int) Math.abs((tileRow * currentLayer.getTileHeight() / 2 + playerY) / (currentLayer.getTileHeight() / 2));
        if (currentLayer.getCell(tileRow, tileCol).getTile().getId() == 3) {
            return true;
        }
    }
    return false;
}