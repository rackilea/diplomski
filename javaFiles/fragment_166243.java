boolean result = false;
    float points[] = getPoints();  // Get all points of our shape
    int length = points.length;  // count them. here length==1

    if (!closed()) {
        length -= 2;  // as we see the point is a closed shape, here length=-1
    }
    for(int i=0;i<length;i+=2) {  // Does not even enter the complicated work because length == -1
        // Complicated thing to test if intersect with a lot off points
    }
    return result; // here return false