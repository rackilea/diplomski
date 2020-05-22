Point3d p = new Point3d(x, y, z);
if(x < 0 || y < 0 || z < 0) {
    negativeCoord.put(currentIndex, p);
} else {
    positiveCoord.put(currentIndex, p);
}
currentIndex++;