int axis = node.depth % node.k;
KdNode lesser = node.lesser;
KdNode greater = node.greater;

//Search children branches, if axis aligned distance is less than current distance
if (lesser!=null && !examined.contains(lesser)) {
    examined.add(lesser);

    double p1 = Double.MIN_VALUE;
    double p2 = Double.MIN_VALUE;
    if (axis==X_AXIS) {
        p1 = node.id.x;
        p2 = value.x-lastDistance;
    } else if (axis==Y_AXIS) {
        p1 = node.id.y;
        p2 = value.y-lastDistance;
    } else {
        p1 = node.id.z;
        p2 = value.z-lastDistance;
    }
    boolean lineIntersectsCube = ((p2<=p1)?true:false);

    //Continue down lesser branch
    if (lineIntersectsCube) {
        searchNode(value,lesser,K,results,examined);
    }
}
if (greater!=null && !examined.contains(greater)) {
    examined.add(greater);

    double p1 = Double.MIN_VALUE;
    double p2 = Double.MIN_VALUE;
    if (axis==X_AXIS) {
        p1 = node.id.x;
        p2 = value.x+lastDistance;
    } else if (axis==Y_AXIS) {
        p1 = node.id.y;
        p2 = value.y+lastDistance;
    } else {
        p1 = node.id.z;
        p2 = value.z+lastDistance;
    }
    boolean lineIntersectsCube = ((p2>=p1)?true:false);

    //Continue down greater branch
    if (lineIntersectsCube) {
        searchNode(value,greater,K,results,examined);
    }
}