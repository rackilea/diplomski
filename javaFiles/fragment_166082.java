float AreaWidth = message.getWidth();
float AreaLength = message.getLength();

Fi = message.quaternion.toEulerAngles().getY();
cs = Math.cos(Fi);
sn = Math.sin(Fi);

// First, move the target from word axis origin to player axis origin
float tx = (bwNode.getLoc().getX() - message.loc.getX());
float tz = (bwNode.getLoc().getZ() - message.loc.getZ());

// Now rotate the target around it new word origin to apply player rotation
float ptx = cs * tx - sn * tz;
float ptz = sn * tx + cs * tz;

// Now ptx and ptz are in new word coordinates, simply test them agains area
if (-AreaWidth / 2 <= ptx && ptx <= AreaWidth / 2 && AreaLength => 0 && AreaLength <= l) {
    // It is inside
} else {
    // It is outside
}