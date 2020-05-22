Set<Point> uniques = new HashSet<Point>();

for ( int i = 0; i < matrix.length; i++ ){//loop over rows
    for ( int j = 0; j < matrix[i].length; j++ ){
        Point p = new Point(rand.nextInt(matrix.length), rand.nextInt(matrix[i].length));
        while ( uniques.contains(p) ){
            p = new Point(rand.nextInt(matrix.length), rand.nextInt(matrix[i].length));
        }
        uniques.add(p);
        //p.x and p.y contain the indexes
    }
}