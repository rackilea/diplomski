CheckPoint a = null, b = null, c = null;
for (CheckPoint checkPoint : checkPointList) {
    String tag = checkPoint.getTag();
    if ("A".equals(tag) && a == null) {
        a = checkPoint;
    } else if("B".equals(tag)){
        b = checkPoint;
    } else if("C".equals(tag)){
        c = checkPoint;
    }
}