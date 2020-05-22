public static double totalDistance(int[] x, int[] y, int i){
         int distance = pow(x[i] – x[i – 1], 2) + pow(y[i] – y[i – 1], 2);
        if (x.length == 1){
           return distance;
        }
        else {
            return round(sqrt(distance)) + totalDistance(x,y,i-1);
        }
}