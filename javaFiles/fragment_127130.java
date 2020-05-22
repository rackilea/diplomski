//euclidean distance (?)
double distance (Point other) {
    Point result = new Point(); 
    result.ycoord = Math.abs (ycoord - other.ycoord);
    result.xcoord = Math.abs (xcoord- other.xcoord);    
    result.distance = Math.sqrt((result.ycoord)*(result.ycoord) +(result.xcoord)*(result.xcoord));
    System.out.println(result);
    return result.distance; 
    }
}