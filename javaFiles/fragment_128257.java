static double[][] getPoints(Path2D path) {
    List<double[]> pointList = new ArrayList<double[]>();
    double[] coords = new double[6];
    int numSubPaths = 0;
    for (PathIterator pi = path.getPathIterator(null);
         ! pi.isDone();
         pi.next()) {
        switch (pi.currentSegment(coords)) {
        case PathIterator.SEG_MOVETO:
            pointList.add(Arrays.copyOf(coords, 2));
            ++ numSubPaths;
            break;
        case PathIterator.SEG_LINETO:
            pointList.add(Arrays.copyOf(coords, 2));
            break;
        case PathIterator.SEG_CLOSE:
            if (numSubPaths > 1) {
                throw new IllegalArgumentException("Path contains multiple subpaths");
            }
            return pointList.toArray(new double[pointList.size()][]);
        default:
            throw new IllegalArgumentException("Path contains curves");
        }
    }
    throw new IllegalArgumentException("Unclosed path");
}