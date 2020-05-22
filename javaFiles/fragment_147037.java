onmousedown {
    startpoint = (x,y);
    startangle = getAngle(origin, startpoint);
}

onmousemove {
    currentpoint = (x,y);
    currentangle = getAngle(origin, currentpoint);
    originalimage.rotate(currentangle - startangle);
}

getAngle(origin, other) {
    dy = other.y - origin.y;
    dx = other.x - origin.x;
    if (dx == 0) // special case
        angle = dy >= 0? PI/2: -PI/2;
    else
    {
        angle = Math.atan(dy/dx);
        if (dx < 0) // hemisphere correction
            angle += PI;
    }
    // all between 0 and 2PI
    if (angle < 0) // between -PI/2 and 0
        angle += 2*PI;
    return angle;
}