int axis = node.depth % node.k;
KdNode lesser = node.lesser;
KdNode greater = node.greater;

//Search children branches, if axis aligned distance is less than current distance
if (lesser!=null && !examined.contains(lesser)) {
    examined.add(lesser);

    boolean lineIntersectsRect = false;
    Line line = null;
    Cube cube = null;
    if (axis==X_AXIS) {
        line = new Line(new Point(value.x-lastDistance,value.y,value.z), new Point(value.x+lastDistance,value.y,value.z));
        Point tul = new Point(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY);
        Point tur = new Point(node.id.x,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY);
        Point tlr = new Point(node.id.x,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY);
        Point tll = new Point(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY);
        Rectangle trect = new Rectangle(tul,tur,tlr,tll);
        Point bul = new Point(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
        Point bur = new Point(node.id.x,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
        Point blr = new Point(node.id.x,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        Point bll = new Point(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        Rectangle brect = new Rectangle(bul,bur,blr,bll);
        cube = new Cube(trect,brect);
        lineIntersectsRect = cube.inserects(line);
    } else if (axis==Y_AXIS) {
        line = new Line(new Point(value.x,value.y-lastDistance,value.z), new Point(value.x,value.y+lastDistance,value.z));
        Point tul = new Point(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY);
        Point tur = new Point(Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY);
        Point tlr = new Point(Double.POSITIVE_INFINITY,node.id.y,Double.NEGATIVE_INFINITY);
        Point tll = new Point(Double.NEGATIVE_INFINITY,node.id.y,Double.NEGATIVE_INFINITY);
        Rectangle trect = new Rectangle(tul,tur,tlr,tll);
        Point bul = new Point(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
        Point bur = new Point(Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
        Point blr = new Point(Double.POSITIVE_INFINITY,node.id.y,Double.POSITIVE_INFINITY);
        Point bll = new Point(Double.NEGATIVE_INFINITY,node.id.y,Double.POSITIVE_INFINITY);
        Rectangle brect = new Rectangle(bul,bur,blr,bll);
        cube = new Cube(trect,brect);
        lineIntersectsRect = cube.inserects(line);
    } else {
        line = new Line(new Point(value.x,value.y,value.z-lastDistance), new Point(value.x,value.y,value.z+lastDistance));
        Point tul = new Point(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY);
        Point tur = new Point(Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY);
        Point tlr = new Point(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY);
        Point tll = new Point(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY);
        Rectangle trect = new Rectangle(tul,tur,tlr,tll);
        Point bul = new Point(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,node.id.z);
        Point bur = new Point(Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY,node.id.z);
        Point blr = new Point(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,node.id.z);
        Point bll = new Point(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,node.id.z);
        Rectangle brect = new Rectangle(bul,bur,blr,bll);
        cube = new Cube(trect,brect);
        lineIntersectsRect = cube.inserects(line);
    }

    //Continue down lesser branch
    if (lineIntersectsRect) {
        searchNode(value,lesser,K,results,examined);
    }
}
if (greater!=null && !examined.contains(greater)) {
    examined.add(greater);

    boolean lineIntersectsRect = false;
    Line line = null;
    Cube cube = null;
    if (axis==X_AXIS) {
        line = new Line(new Point(value.x-lastDistance,value.y,value.z), new Point(value.x+lastDistance,value.y,value.z));
        Point tul = new Point(node.id.x,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY);
        Point tur = new Point(Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY);
        Point tlr = new Point(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY);
        Point tll = new Point(node.id.x,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY);
        Rectangle trect = new Rectangle(tul,tur,tlr,tll);
        Point bul = new Point(node.id.x,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
        Point bur = new Point(Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
        Point blr = new Point(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        Point bll = new Point(node.id.x,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        Rectangle brect = new Rectangle(bul,bur,blr,bll);
        cube = new Cube(trect,brect);
        lineIntersectsRect = cube.inserects(line);
    } else if (axis==Y_AXIS) {
        line = new Line(new Point(value.x,value.y-lastDistance,value.z), new Point(value.x,value.y+lastDistance,value.z));
        Point tul = new Point(Double.NEGATIVE_INFINITY,node.id.y,Double.NEGATIVE_INFINITY);
        Point tur = new Point(Double.POSITIVE_INFINITY,node.id.y,Double.NEGATIVE_INFINITY);
        Point tlr = new Point(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY);
        Point tll = new Point(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY);
        Rectangle trect = new Rectangle(tul,tur,tlr,tll);
        Point bul = new Point(Double.NEGATIVE_INFINITY,node.id.y,Double.POSITIVE_INFINITY);
        Point bur = new Point(Double.POSITIVE_INFINITY,node.id.y,Double.POSITIVE_INFINITY);
        Point blr = new Point(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        Point bll = new Point(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        Rectangle brect = new Rectangle(bul,bur,blr,bll);
        cube = new Cube(trect,brect);
        lineIntersectsRect = cube.inserects(line);
    } else {
        line = new Line(new Point(value.x,value.y,value.z-lastDistance), new Point(value.x,value.y,value.z+lastDistance));
        Point tul = new Point(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,node.id.z);
        Point tur = new Point(Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY,node.id.z);
        Point tlr = new Point(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,node.id.z);
        Point tll = new Point(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,node.id.z);
        Rectangle trect = new Rectangle(tul,tur,tlr,tll);
        Point bul = new Point(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
        Point bur = new Point(Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
        Point blr = new Point(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        Point bll = new Point(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        Rectangle brect = new Rectangle(bul,bur,blr,bll);
        cube = new Cube(trect,brect);
        lineIntersectsRect = cube.inserects(line);
    }

    //Continue down greater branch
    if (lineIntersectsRect) {
        searchNode(value,greater,K,results,examined);
    }
}