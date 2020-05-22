// The tank will move this distance in x or y before changing directions
private final int MOVE_BLOCK = 120;
// The short-term target of the enemy tank
Point target = null;
public void enemyMove(Tank t) {
    /* true if enemy is moving left and enemy is already left of target point, 
     * or moving right and right of target... */
    boolean passedTarget = target == null || 
        (dx < 0 && getX() < target.getX()) ||
        (dx > 0 && getX() > target.getX()) ||
        (dy < 0 && getY() < target.getY()) ||
        (dy > 0 && getY() > target.getY());
    // Calculate a new target point if the old target was passed
    if(passedTarget) {
        int xDist = Math.abs(getX() - t.getX());
        int yDist = Math.abs(getY() - t.getY());
        if ( xDist > yDist ) {
            // Cover the remaining distance when close to the target
            int moveLength = xDist < MOVE_BLOCK ? xDist : MOVE_BLOCK;
            if( getX() >= t.getX() )
                goLeft();
                target = new Point(getX() - moveLength, getY());
            else
                goRight();
                target = new Point(getX() + moveLength, getY());
        } else {
            int moveLength = yDist < MOVE_BLOCK ? yDist : MOVE_BLOCK;
            if ( getY() >= t.getY() ) {
                goUp();
                target = new Point(getX(), getY() - moveLength);
            } else {
                goDown();
                target = new Point(getX(), getY() + moveLength);
            }
        }
    }

    setX(getX() + dx);
    setY(getY() + dy);
}