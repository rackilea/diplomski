double longestDistanceSquared = 0;
int mostDistantPointIndex = -1;
for (int k = 0; k < coordsX.length; k++){
    double distanceSquared = Math.pow(coordsX[k] - x_coord, 2) + Math.pow(coordsY[k] - y_coord, 2);
    if (distanceSquared > longestDistanceSquared){
        longestDistanceSquared = distanceSquared;
        mostDistantPointIndex = k;
    }
}